******************controller**********************
//
//  EIInteriorRoomsViewController.swift
//  EXOSInspect
//
//  Created by Pamarthi, Viswanath on 3/31/20.
//  Copyright © 2020 ServiceLink. All rights reserved.
//

import UIKit

class EIInteriorRoomsViewController: EIBaseViewController {
    
    @IBOutlet weak var roomsTableView: UITableView!
    @IBOutlet weak var screenTitle: UILabel!
    @IBOutlet weak var screenSubTitle: UILabel!
    @IBOutlet weak var progressBarView: EIProgressBarView!
    
    var feedbackTableViewCell : EIFeedbackSegmentTableViewCell?
    
    @IBAction func nextButtonAction(_ sender: Any) {
        
        //navigate video capture page when edit is enable,no need to call postroom
        if viewModel?.hasUserClickedPreButton ?? false{
            
            Navigation.Instance.navigateToInteriorVideoCapture()
            return
        }
        LoggerHelper.shared.logAction("Pressed interior room next button", actionType: .next, page: .interiorArea)
        
        let cancel =  UIAlertAction(title: " Back to edit", style: .default, handler: { (action: UIAlertAction!) in
            //cancel
        })
        let delete =  UIAlertAction(title: "Yes", style: .default, handler: { (action: UIAlertAction!) in
            LoggerHelper.shared.logAction("Pressed interior room confirm button", actionType: .confirm, page: .interiorArea)
            self.viewModel?.updateInteriorRoomFeedback()
        })
        self.showAlert(withTitle: "Did we capture all of the interior rooms in your property?",andMessage: "Please make sure you listed out all of the rooms in your property. If not, click ‘Back to edit’, otherwise, click ‘Yes’",alertActions: [cancel,delete])
    }
    
    
    @IBAction func previousButtonAction(_ sender: Any) {
        LoggerHelper.shared.logAction("Pressed interior room previous button", actionType: .previous, page: .interiorArea)
        Navigation.Instance.navigateBackToTaskList()
    }
    
    var viewModel: EIInteriorRoomsViewControllerConfigurable?
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.page = .interiorArea
        
        let headerView = TitleAndHeaderInfoView.loadFromXib(withOwner: self, options: nil) as TitleAndHeaderInfoView
        headerView.headerInfoText = viewModel?.headerInfoText
        headerView.screenTitle =  viewModel?.screenTitle
        roomsTableView.tableHeaderView = headerView
        
        progressBarView.currentStep = .interionInfo
        
        self.registerCells();
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        self.view.endEditing(true)
    }
    
    override func viewWillLayoutSubviews() {
        roomsTableView.reloadData()
    }
    
    @objc func dismissKeyboard() {
        
        view.endEditing(true)
    }
    private func registerCells() {
        
        let  frameworkBundle=Utils.sharedInstance.frameworkBundle
        
        let tableHeaderViewNib = UINib(nibName: EITableSectionHeaderView.resueIdentifier(), bundle: frameworkBundle)
        roomsTableView.register(tableHeaderViewNib, forHeaderFooterViewReuseIdentifier: EITableSectionHeaderView.resueIdentifier())
        let currentConditionNib = UINib(nibName: EIFeedbackSegmentTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        let eIRoomCountTableViewCell=UINib(nibName: EIRoomCountTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        let eISpacesInHouseTableViewCell=UINib(nibName: EISpacesInHouseTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        let eIOtherSpaceDescTableViewCell=UINib(nibName: EIOtherSpaceDescTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        let addNewRoomTableViewCell = UINib(nibName: EIAddRoomTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        let editRoomButtonTableViewCell = UINib(nibName: EIEditRoomButtonTableViewCell.resueIdentifier(), bundle: frameworkBundle)
        
        roomsTableView.register(eIRoomCountTableViewCell, forCellReuseIdentifier: EIRoomCountTableViewCell.resueIdentifier())
        roomsTableView.register(eISpacesInHouseTableViewCell, forCellReuseIdentifier: EISpacesInHouseTableViewCell.resueIdentifier())
        roomsTableView.register(eIOtherSpaceDescTableViewCell, forCellReuseIdentifier: EIOtherSpaceDescTableViewCell.resueIdentifier())
        roomsTableView.register(addNewRoomTableViewCell, forCellReuseIdentifier: EIAddRoomTableViewCell.resueIdentifier())
        roomsTableView.register(currentConditionNib, forCellReuseIdentifier: EIFeedbackSegmentTableViewCell.resueIdentifier())
        roomsTableView.register(editRoomButtonTableViewCell, forCellReuseIdentifier: EIEditRoomButtonTableViewCell.resueIdentifier())
        
    }
}

extension EIInteriorRoomsViewController:UITableViewDataSource, UITableViewDelegate{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        guard let numberofRows = viewModel?.numberOfRowsIn(section: section) else {
            return 0
        }
        
        return  numberofRows
    }
    
    func tableView(_ tableView: UITableView, willDisplay cell: UITableViewCell, forRowAt indexPath: IndexPath) {
        let contentView = cell.contentView
        if
            // this separator is subview of first UITableViewCell in section
            indexPath.row == 0,
            // truing to find it in subviews
            let divider = cell.subviews.filter({ $0.frame.minY == 0 && $0 !== contentView }).first
        {
            divider.isHidden = true
        }
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let sectionType   = viewModel?.getSectionType(section: indexPath.section) else {
            return UITableViewCell()
        }
        
        let cellType = viewModel?.getCellTypeAt(row: indexPath.row, in: sectionType)
        
        switch cellType {
        case .condition:
            return self.tableView(tableView, cellForInterioPropertyConditionAt: indexPath)
        case .bedroom:
            return self.tableView(tableView, cellForInteriorBedroomAt: indexPath)
        case .fullBathroom:
            return self.tableView(tableView, cellForInteriorFullBathRoomAt: indexPath)
        case .halfBathroom:
            return self.tableView(tableView, cellForInteriorHalfBathRoomAt: indexPath)
        case .kitchen:
            return self.tableView(tableView, cellForInteriorKitchenAt: indexPath)
        case .livingRoom:
            return self.tableView(tableView, cellForInteriorLivingRoomAt: indexPath)
        case .dinningRoom:
            return self.tableView(tableView, cellForInteriorDiningRoomAt:  indexPath)
        case .denOrFamilyRoom:
            return self.tableView(tableView, cellForInteriorFamiliyRoomAt: indexPath)
        case .finishedBasement:
            return self.tableView(tableView, cellForInteriorFinishedBasementRoomAt:indexPath)
        case .addOthers:
            return self.tableView(tableView, cellForInteriorOtherSpaceAt: indexPath)
        case .spacesInHouseSubtitle:
            return self.tableView(tableView, cellForInteriorSpacesInHouseSubTitleAt: indexPath)
        case .others:
            return self.tableView(tableView, cellForOtherRoomAt: indexPath)
        case .editRoom:
            return self.tableView(tableView, cellForInteriorEditRoomAt: indexPath)
            
        default:
            return UITableViewCell();
        } 
    }
    
    
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        guard let sectionType   = viewModel?.getSectionType(section: indexPath.section) else {
            return
        }
        let cellType = viewModel?.getCellTypeAt(row: indexPath.row, in: sectionType)
        if cellType == .addOthers{
            let frameworkBundle = Utils.sharedInstance.frameworkBundle
            let viewController = EIAddOtherRoomViewController(nibName: "EIAddOtherRoomViewController", bundle: frameworkBundle)
            viewController.viewModel = EIAddOtherRoomViewModel()
            viewController.delegate = self
            let navConntroller = UINavigationController(rootViewController: viewController)
            self.present(navConntroller, animated: true, completion: nil)
        }
    }
    
    
    func numberOfSections(in tableView: UITableView) -> Int {
        
        guard let sectionCount = viewModel?.numberOfSections() else {
            return 1
        }
        
        return sectionCount
    }
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        
        if section == 0
        {
            return CGFloat.leastNormalMagnitude
        }
        
        return UITableView.automaticDimension
    }
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        
        //hide separator line for edit room button cell section
        if viewModel?.hasUserClickedPreButton ?? false {
            let result = UIView()
            if section == 0{
                // recreate insets from existing ones in the table view
                let insets = tableView.separatorInset
                let width = tableView.bounds.width - insets.left - insets.right
                let sepFrame = CGRect(x: insets.left, y: -0.5, width: width, height: 0.5)
                
                // create layer with separator, setting color
                let sep = CALayer()
                sep.frame = sepFrame
                sep.backgroundColor = UIColor.white.cgColor
                result.layer.addSublayer(sep)
            }
            return result
        }
        return nil
    }
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return 0.0
    }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        guard let cell = tableView.dequeueReusableHeaderFooterView(withIdentifier: EITableSectionHeaderView.resueIdentifier()) as? EITableSectionHeaderView else {
            return nil
        }
        cell.titleText = viewModel?.getTitleFor(section: section)
        cell.shouldHideButton=true
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorBedroomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.selectionStyle = .none
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .bedroom);
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorEditRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIEditRoomButtonTableViewCell.resueIdentifier(), for: IndexPath) as? EIEditRoomButtonTableViewCell else {
            return UITableViewCell()
        }
        cell.separatorInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: .greatestFiniteMagnitude)
        cell.selectionStyle = .none
        cell.delegate = self
        cell.editButton.setTitle("Edit room list", for: .normal)
        return cell
    }
    
    //property ondition 
    func tableView(_ tableView:UITableView, cellForInterioPropertyConditionAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIFeedbackSegmentTableViewCell.resueIdentifier(), for: IndexPath) as? EIFeedbackSegmentTableViewCell else {
            return UITableViewCell()
        }
        
        cell.titleText = "What is the condition of the interior of the property:";
        cell.selectionStyle = .none
        cell.delegate = self
        cell.indexPath = IndexPath
        self.feedbackTableViewCell  = cell
        cell.selectedItem = viewModel?.property?.interiorCondition
        
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorFullBathRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .fullBathroom);
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorHalfBathRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .halfBathroom);
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorKitchenAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .kitchen);
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorLivingRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .livingRoom);
        cell.selectionStyle = .none
        return cell
    }
    
    
    func tableView(_ tableView:UITableView, cellForInteriorDiningRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .dinningRoom);
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorFamiliyRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .denOrFamilyRoom);
        cell.selectionStyle = .none
        return cell
    }
    
    
    func tableView(_ tableView:UITableView, cellForInteriorFinishedBasementRoomAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIRoomCountTableViewCell.resueIdentifier(), for: IndexPath) as? EIRoomCountTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.setEditRoom(hasUserEditRoom: viewModel?.hasUserClickedPreButton ?? false)
        cell.viewModel=viewModel?.getRoomCountCellViewModelFor(cellType: .finishedBasement);
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorSpacesInHouseSubTitleAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EISpacesInHouseTableViewCell.resueIdentifier(), for: IndexPath) as? EISpacesInHouseTableViewCell else {
            return UITableViewCell()
        }
        
        cell.viewModel=viewModel?.getSpacesInHouseCellViewModelFor(cellType: .spacesInHouseSubtitle);
        cell.separatorInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: .greatestFiniteMagnitude)
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForInteriorOtherSpaceAt IndexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIOtherSpaceDescTableViewCell.resueIdentifier(), for: IndexPath) as? EIOtherSpaceDescTableViewCell else {
            return UITableViewCell()
        }
        cell.delegate=self
        cell.viewModel=viewModel?.getOtherSpaceDescCellViewModelFor(cellType: .addOthers)
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView:UITableView, cellForOtherRoomAt indexPath:IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: EIAddRoomTableViewCell.resueIdentifier(), for: indexPath) as? EIAddRoomTableViewCell else {
            return UITableViewCell()
        }
        cell.viewModel=viewModel?.getAddOtherRoomCellViewModelFor(cellType: .others, title: viewModel?.getNewRoomTitle(for: indexPath.row) ?? "N/A")
        cell.setRoom(hasEditEnable: viewModel?.hasUserClickedPreButton ?? false)
        cell.indexPath  = indexPath
        cell.selectionStyle = .none
        cell.delegate = self
        return cell
    }
}

extension EIInteriorRoomsViewController:InteriorRoomCountDelegate
{
    func updateInteriorRoomCount(_ interiorRoomsCellType: InteriorRoomsCellType, _ roomCount: Int) {
        viewModel?.updateInteriorRoomCount(interiorRoomsCellType, roomCount)
    }
}

extension EIInteriorRoomsViewController:EIOtherSpaceTableViewCellDelegate
{
    func keyboardWillHide(notification: NSNotification) {
        if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue) != nil {
            
            if self.view.frame.origin.y != 0 {
                self.view.frame.origin.y = 0
            }
        }
    }
    
    func keyboardWillShow(notification: NSNotification) {
        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameBeginUserInfoKey] as? NSValue)?.cgRectValue {
            if self.view.frame.origin.y==0{
                self.view.frame.origin.y -= keyboardSize.height
            }
        }
    }
    
    func UpdateOtherSpaceTableViewCellData(_ otherSpaceDescinfo: EIOtherSpaceDescModel) {
        self.roomsTableView.beginUpdates()
        viewModel?.UpdateOtherSpaceData(otherSpaceDescinfo)
        self.roomsTableView.endUpdates()
        
        if(self.view.frame.origin.y != 0)
        {
            self.view.endEditing(true)
        }
    }
}

//delegate methods for Add Other room
extension EIInteriorRoomsViewController:EIAddOtherRoomViewControllerDelegate{
    func didAddTapped(with name: String, and description: String, has roomType: RoomType) {
        viewModel?.addNewRoom(in: .spacesInHouse, at: 0, cellType: .others,title: name, description: description)
        roomsTableView.reloadData()
    }
}

extension EIInteriorRoomsViewController:EIAddRoomTableViewCellDelegate{
    
    func didDeleteRoom(at indexPath:IndexPath?){
        LoggerHelper.shared.logAction("Pressed interior room delete button", actionType: .delete, page: .interiorArea)
        let cancel =  UIAlertAction(title: "Cancel", style: .default, handler: { (action: UIAlertAction!) in
            //cancel
        })
        let delete =  UIAlertAction(title: "Delete", style: .destructive, handler: { (action: UIAlertAction!) in
            guard let index = indexPath?.row else {
                return
            }
            LoggerHelper.shared.logAction("Pressed interior room delete confirm button", actionType: .confirm, page: .interiorArea)
            self.viewModel?.deleteNewRoom(in: index)
            DispatchQueue.main.async {
                self.roomsTableView.reloadData()
            }
        })
        
        self.showAlert(withTitle: "Are you sure you want to delete this room?",andMessage: "You will lose the information about this room once you delete it. This action can’t be undone",alertActions: [cancel,delete])
    }
}

extension EIInteriorRoomsViewController:EIFeedbackSegmentCellDelegate{
    func segement(_ segmentControl: UISegmentedControl, didSelect item: FeedbackItem, at indexPath: IndexPath?) {
        viewModel?.property?.interiorCondition = item
    }
}
extension EIInteriorRoomsViewController: EIEditRoomButtonTableViewCellDelegate{
    
    func didEditRoomTapped() {
        
        LoggerHelper.shared.logAction("Pressed edit room  button", actionType: .info, page: .interiorArea)
        
        let alert = UIAlertController(title: "Add or delete interior rooms", message: "", preferredStyle: .actionSheet)
        
        let deleteRooms = UIAlertAction(title: "Delete room", style: .destructive, handler: { (action: UIAlertAction!) in
            
            LoggerHelper.shared.logAction("Pressed Delete room pop up", actionType: .info, page: .interiorArea)
            
            Navigation.Instance.navigateToInteriorAddDeleteRoom(from: self, roomAction: RoomAction.deleteRoom)
        })
        let addRooms = UIAlertAction(title: "Add rooms", style: .default, handler: { (action: UIAlertAction!) in
            
            LoggerHelper.shared.logAction("Pressed Add room pop up", actionType: .info, page: .interiorArea)
            
            Navigation.Instance.navigateToInteriorAddDeleteRoom(from: self, roomAction: RoomAction.addRoom)
        })
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel, handler: { (action: UIAlertAction!) in
            self.dismiss(animated: true, completion: nil)
        })
        
        alert.addAction(addRooms)
        alert.addAction(deleteRooms)
        alert.addAction(cancelAction)
        
        alert.popoverPresentationController?.sourceView = self.view
        alert.popoverPresentationController?.sourceRect = CGRect(x: self.view.bounds.size.width / 2.0, y: self.view.bounds.size.height / 2.0, width: 1.0, height: 1.0)
        self.present(alert, animated: true, completion: nil)
    }
}

extension EIInteriorRoomsViewController : EIAddRoomViewControllerDelegate {
    func refreshPage(room: Room?,roomAction:RoomAction?) {
        if let _ = room {
            reinitializeInteriorRooms(room: room, roomAction: roomAction)
        }
    }
    
    func reinitializeInteriorRooms(room:Room?,roomAction:RoomAction?)
    {
        CustomMessageWindows.instance.showLoading()
        //Always reload all the status of the rooms
        SessionData.instance.reInitializeVideos({ result in
            self.viewModel!.setUpData(room: room, roomAction: roomAction)
            self.roomsTableView.reloadData()
            CustomMessageWindows.instance.hide()
        })
        
        *************model/interface***********************************************************
        //
//  EIInteriorRoomsViewConfigurable.swift
//  EXOSInspect
//
//  Created by Pamarthi, Viswanath on 4/2/20.
//  Copyright © 2020 ServiceLink. All rights reserved.
//

import Foundation



enum InteriorRoomsTableSection {
    case condition
    case bedrooms
    case bathrooms
    case spacesInHouse
    case editRoom
}

enum InteriorRoomsCellType:String{
    
    case condition = "Condition"
    case  bedroom="Bedrooms"
    case  fullBathroom="Full Bathroom"
    case  halfBathroom="Half Bathroom"
    case  kitchen="Kitchen"
    case  livingRoom="Living Room"
    case  dinningRoom="Dining Room"
    case  denOrFamilyRoom="Den/Family Room"
    case  finishedBasement="Finished Basement"
    case  others
    case  spacesInHouseSubtitle
    case addOthers = "Others"
    case pool = "Pool"
    case garage = "Garage / Car-port"
    case otherStructure
    case addOtherStructure = "Other Structures"
    case editRoom = "edit room"
}

protocol EIInteriorRoomsViewControllerConfigurable :EITableViewCommonConfigurable {
    
    var screenTitle:String {get}
    var headerInfoText: String { get }
    var interiorRoomsInfo:EIInteriorRoomsInfo{get set}
    func getCellTypeAt(row: Int, in section: InteriorRoomsTableSection) -> InteriorRoomsCellType
    func getTitleFor(section: Int) -> String?
    func getSectionType(section: Int) -> InteriorRoomsTableSection
    func getOtherSpaceDescCellViewModelFor(cellType: InteriorRoomsCellType) -> EIOtherSpaceDescTableViewCellViewModel?
    func getRoomCountCellViewModelFor(cellType: InteriorRoomsCellType) -> EIRoomCountTableViewCellViewModel?
    func getSpacesInHouseCellViewModelFor(cellType: InteriorRoomsCellType) -> EISpacesInHouseTableViewCellViewModel?
    func updateInteriorRoomCount(_ interiorRoomsCellType:InteriorRoomsCellType,_ roomCount:Int)
    func UpdateOtherSpaceData(_ otherSpaceDescinfo: EIOtherSpaceDescModel)
    func addNewRoom(in section: InteriorRoomsTableSection, at index: Int, cellType: InteriorRoomsCellType,title:String, description: String)
   func getAddOtherRoomCellViewModelFor(cellType: InteriorRoomsCellType,title:String) -> EIAddOtherRoomTableViewCellViewModel?
    func getNewRoomTitle(for row:Int)->String?
    func deleteNewRoom(in index:Int)
    func setUpData(room:Room?,roomAction:RoomAction?)
    func createAndGetRoom()
    func updateInteriorRoomFeedback()
    var property : Property? {get set}
    var hasUserClickedPreButton:Bool?{get set}
}

struct EIInteriorRoomsInfo {
    var bedroomCount:Int=0
    var fullBathRoomCount:Int=0
    var halfBathRoomCount:Int=0
    var kitchenCount:Int=0
    var livingRoomCount:Int=0
    var diningRoomCount:Int=0
    var denOrFamilyRoomCount=0
    var finishedBasementCount=0
    var areOtherSpacesAvailable:Bool=false
    var otherSpacesDescription:String?
}

    }
}

*************view model***********************************************************
//
//  EIInteriorRoomsControllerViewModel.swift
//  EXOSInspect
//
//  Created by Pamarthi, Viswanath on 4/2/20.
//  Copyright © 2020 ServiceLink. All rights reserved.
//

import Foundation


class EIInteriorRoomsControllerViewModel:EIInteriorRoomsViewControllerConfigurable {
    
    private var sections: [InteriorRoomsTableSection] = [.condition,.bedrooms,.bathrooms, .spacesInHouse]
    private var rowInCondition:[InteriorRoomsCellType] = [.condition]
    private var rowsInBedrooms: [InteriorRoomsCellType] = [.bedroom]
    private var rowsBathroomsType: [InteriorRoomsCellType] = [.fullBathroom, .halfBathroom]
    private var rowsSpacesInHouseType: [InteriorRoomsCellType] = [.spacesInHouseSubtitle, .kitchen, .livingRoom, .dinningRoom, .denOrFamilyRoom, .finishedBasement,.addOthers]
    private var rowsInEditRoom:[InteriorRoomsCellType] = [.editRoom]
    var lstNewRooms : [Room] = []
    var lstOtherNewRooms : [Room] = []
    
    var fixedRoomCount = 6
    var headerInfoText: String = ""
    var screenTitle: String = ""
    var interiorRoomsInfo: EIInteriorRoomsInfo
    var addOtherRoomTitle:String?
    var deleteRoomList = [String]()
    var hasInitialData = false
    var existingRoomsLst : [Room] = []
    var property : Property?
    var hasUserClickedPreButton:Bool?
    
    init(has hasPreviousButtonClicked:Bool){
        screenTitle="Interior Rooms"
        headerInfoText="Please verify the number of Bedrooms, Bathrooms, Half Bathrooms and other spaces in your property."
        hasUserClickedPreButton = hasPreviousButtonClicked
        interiorRoomsInfo=EIInteriorRoomsInfo()
        existingRoomsLst = RoomVideoProcessor.instance.getRoomByType(type: .interior)
        for other in existingRoomsLst.filter({ $0.roomType == .others }) {
            lstOtherNewRooms.append(other)
            rowsSpacesInHouseType.insert(InteriorRoomsCellType.others, at: rowsSpacesInHouseType.count-1)
        }
        //Has avm data if any room name comes empty
        hasInitialData = existingRoomsLst.count > 0
        
        updateRoomCount()
        
        self.property = SessionData.instance.property
        setDefaults()
        editRoomLogic()
        
    }
    
    func setUpData(room:Room?,roomAction:RoomAction?) {
        existingRoomsLst.removeAll()
        existingRoomsLst = RoomVideoProcessor.instance.getRoomByType(type: .interior)
        if(roomAction == .deleteRoom){
            if let deleteRoom = room{
                if deleteRoom.roomType == .others{
                if let index = lstOtherNewRooms.firstIndex(where: {$0.roomName == deleteRoom.roomName}) {
                    lstOtherNewRooms.remove(at: index)
                }
                rowsSpacesInHouseType.removeLast()
            }
            }
        }else{
            if let addRoom = room{
                if addRoom.roomType == .others{
                    lstOtherNewRooms.append(addRoom)
                    rowsSpacesInHouseType.insert(InteriorRoomsCellType.others, at: rowsSpacesInHouseType.count)
                }
            }
        }
        updateRoomCount()
    }
    
    func editRoomLogic(){
        if hasUserClickedPreButton!{
            rowInCondition.insert(.editRoom, at: 1)
            rowsSpacesInHouseType.removeLast()
        }
    }
    
    func updateRoomCount(){
        //In the future it should auto populte all fields because we will be able to edit
        
        if(existingRoomsLst.count>0){
            interiorRoomsInfo.bedroomCount = existingRoomsLst.filter{$0.roomType == .bedroom}.count
            interiorRoomsInfo.fullBathRoomCount = existingRoomsLst.filter{$0.roomType == .fullBathroom}.count
            interiorRoomsInfo.halfBathRoomCount = existingRoomsLst.filter{$0.roomType == .halfBathroom}.count
            interiorRoomsInfo.kitchenCount = existingRoomsLst.filter{$0.roomType == .kitchen}.count
            interiorRoomsInfo.livingRoomCount = existingRoomsLst.filter{$0.roomType == .livingRoom}.count
            interiorRoomsInfo.diningRoomCount = existingRoomsLst.filter{$0.roomType == .diningRoom}.count
            interiorRoomsInfo.denOrFamilyRoomCount = existingRoomsLst.filter{$0.roomType == .denFamilyRoom}.count
            interiorRoomsInfo.finishedBasementCount = existingRoomsLst.filter{$0.roomType == .finishedBasement}.count
        }
        //Set default to 1
        if interiorRoomsInfo.kitchenCount == 0
        {
            interiorRoomsInfo.kitchenCount = 1
        }
    }
    
    func getCellTypeAt(row: Int, in section: InteriorRoomsTableSection) -> InteriorRoomsCellType {
        switch section {
        case .bedrooms:
            return rowsInBedrooms[row]
        case .bathrooms:
            return rowsBathroomsType[row]
        case .spacesInHouse:
            return rowsSpacesInHouseType[row]
        case .condition:
            return rowInCondition[row]
        case .editRoom:
            return rowsInEditRoom[row]
        }
    }
    
    func getTitleFor(section: Int) -> String? {
        let sectionType = sections[section]
        switch sectionType {
        case .bedrooms:
            return "How many Bedrooms?"
        case .bathrooms:
            return "How many Bathrooms?"
        case .spacesInHouse:
            return "Do you have following spaces in your house?"
        case .condition:
            return nil
        case .editRoom:
            return ""
        }
    }
    
    func getSectionType(section: Int) -> InteriorRoomsTableSection {
        return sections[section]
    }
    
    func getOtherSpaceDescCellViewModelFor(cellType: InteriorRoomsCellType) -> EIOtherSpaceDescTableViewCellViewModel? {
        return EIOtherSpaceDescTableViewCellViewModel(EIOtherSpaceDescModel("room_extOthers", .addOthers, interiorRoomsInfo.areOtherSpacesAvailable, "Please describe:", interiorRoomsInfo.otherSpacesDescription))
    }
    
    func getAddOtherRoomCellViewModelFor(cellType: InteriorRoomsCellType,title:String) -> EIAddOtherRoomTableViewCellViewModel?{
        return EIAddOtherRoomTableViewCellViewModel(title, "finishedBasement")
    }
    
    
    func getRoomCountCellViewModelFor(cellType: InteriorRoomsCellType) -> EIRoomCountTableViewCellViewModel? {
        
        switch cellType {
        case .bedroom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "bedroom", .bedroom, interiorRoomsInfo.bedroomCount))
        case .fullBathroom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "bathroom", .fullBathroom, interiorRoomsInfo.fullBathRoomCount))
        case .halfBathroom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "halfBathroom", .halfBathroom, interiorRoomsInfo.halfBathRoomCount))
            
        case .kitchen:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "kitchen", .kitchen, interiorRoomsInfo.kitchenCount))
            
        case .livingRoom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "livingRoom", .livingRoom, interiorRoomsInfo.livingRoomCount))
            
            
        case .dinningRoom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "diningRoom", .dinningRoom, interiorRoomsInfo.diningRoomCount))
        case .denOrFamilyRoom:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "denOrFamilyRoom", .denOrFamilyRoom, interiorRoomsInfo.denOrFamilyRoomCount))
            
        case .finishedBasement:
            return EIRoomCountTableViewCellViewModel(roomCountInfo: EIRoomCountModel(roomTypeImageAsset: "finishedBasement", .finishedBasement, interiorRoomsInfo.finishedBasementCount))
            
        default:
            return nil
        }
        
    }
    
    func updateInteriorRoomCount(_ interiorRoomsCellType: InteriorRoomsCellType,_ roomCount:Int) {
        switch interiorRoomsCellType {
        case .bedroom:
            interiorRoomsInfo.bedroomCount=roomCount
            break
        case .fullBathroom:
            interiorRoomsInfo.fullBathRoomCount=roomCount
        case .halfBathroom:
            interiorRoomsInfo.halfBathRoomCount=roomCount
            
        case .kitchen:
            interiorRoomsInfo.kitchenCount=roomCount
            
        case .livingRoom:
            interiorRoomsInfo.livingRoomCount=roomCount
            
        case .dinningRoom:
            interiorRoomsInfo.diningRoomCount=roomCount
            
        case .denOrFamilyRoom:
            interiorRoomsInfo.denOrFamilyRoomCount=roomCount
            
        case .finishedBasement:
            self.interiorRoomsInfo.finishedBasementCount=roomCount
            
        default:
            return
        }
    }
    
    
    func updateInteriorRoomFeedback(){
        CustomMessageWindows.instance.showLoading()
        if let prop = property{
            ApiAccess.instance.properties.putProperty(property: prop, completion: { result in
                if(result.isSuccess){
                    SessionData.instance.property = prop
                    self.createAndGetRoom()
                }
                else{
                    self.reloadPageApiCallFailed()
                }
            })
        }
    }
    
    func createAndGetRoom(){
        let data = interiorRoomsInfo
        lstNewRooms = []
        
        createRooms(type: .bedroom, nTotal: data.bedroomCount)
        createRooms(type: .fullBathroom, nTotal: data.fullBathRoomCount)
        createRooms(type: .halfBathroom, nTotal: data.halfBathRoomCount)
        createRooms(type: .kitchen, nTotal: data.kitchenCount)
        createRooms(type: .livingRoom, nTotal: data.livingRoomCount)
        createRooms(type: .diningRoom, nTotal: data.diningRoomCount)
        createRooms(type: .denFamilyRoom, nTotal: data.denOrFamilyRoomCount)
        createRooms(type: .finishedBasement, nTotal: data.finishedBasementCount)
        
        lstNewRooms += lstOtherNewRooms
        
        lstNewRooms = lstNewRooms.filter{ ($0.isNewRoom ?? false) == true}
        //delete first
        if(deleteRoomList.count>0){
            ApiAccess.instance.rooms.deleteRooms(roomIds: deleteRoomList) { result in
                if(!result.isSuccess){
                    self.reloadPageApiCallFailed()
                }
                else{
                    self.executeCreationOfRooms()
                }
            }
        }
        else{
            executeCreationOfRooms()
        }
    }
    
    
    func executeCreationOfRooms()
    {
        ApiAccess.instance.rooms.postRoom(rooms: lstNewRooms) { result in
            if(result.isSuccess)
            {
                self.executeInteriorRoomLogic()
            }
            else{
                self.reloadPageApiCallFailed()
            }
        }
    }
    
    func executeInteriorRoomLogic()
    {
        if(!self.hasInitialData)
        {
            CustomMessageWindows.instance.hide()
            Navigation.Instance.navigateToInteriorVideoCapture()
        }
        else{
            _ = RoomRenamer(type: .interior, complete:
                {
                    result in
                    CustomMessageWindows.instance.hide()
                    if(result)
                    {
                        Navigation.Instance.navigateToInteriorVideoCapture()
                    }
                    else{
                        self.reloadPageApiCallFailed()
                    }
            })
        }
    }
    
    func reloadPageApiCallFailed()
    {
        CustomMessageWindows.instance.hide()
        //TODO show error something happened and reload whole page
    }
    
    
    func createRooms(type : RoomType, nTotal : Int)
    {
        let orderId = SessionData.instance.currentOrderId
        let propertyId = SessionData.instance.property!.id
        var count = 0
        
        let roomObject = existingRoomsLst.filter{$0.roomType == type}
        let totalRoom = nTotal
        
        count = totalRoom - roomObject.count
        
        //while adding room
        if(count>=0){
            for n in stride(from: 1, through: count, by:1)
            {
                var room = Room(videos: [], propertyId: propertyId, roomType: type, name: "", description: "", changes: [], cosmosDocType: "", orderId: orderId, id: "", version: "")
                room.isNewRoom = true
                if(count == 1){
                    room.name = room.roomName + " "
                }else{
                    room.name = room.roomName + " " + String(n)
                }
                lstNewRooms.append(room)
            }
        }
            //add deleted rooms id in array
        else{
            for index in stride(from: 0, to: abs(count), by: 1){
                
                deleteRoomList.append(roomObject[index].id)
            }
        }
    }
    
    func createOtherRoom(name: String, description: String)->Room{
        let type : RoomType = .others
        let orderId = SessionData.instance.currentOrderId
        let propertyId = SessionData.instance.property!.id
        let id = Utils.sharedInstance.generateUUID()
        var room = Room(videos: [], propertyId: propertyId, roomType: type, name: "", description: description, changes: [], cosmosDocType: "", orderId: orderId, id: id, version: "")
        //room.name =  type.roomName + ": " + name
        room.name = name
        room.isNewRoom = true
        return room
    }
    
    func UpdateOtherSpaceData(_ otherSpaceDescinfo: EIOtherSpaceDescModel) {
        
        interiorRoomsInfo.areOtherSpacesAvailable = otherSpaceDescinfo.isRoomOtherType
        interiorRoomsInfo.otherSpacesDescription=otherSpaceDescinfo.otherSpaceDescription
    }
    
    func getSpacesInHouseCellViewModelFor(cellType: InteriorRoomsCellType) -> EISpacesInHouseTableViewCellViewModel? {
        
        return EISpacesInHouseTableViewCellViewModel("This includes common areas, but do not add spaces that are not currently part of the property.", "Add if applicable:")
    }
    
    func numberOfRowsIn(section: Int) -> Int? {
        
        let sectionType = sections[section]
        switch sectionType {
        case .bedrooms:
            return rowsInBedrooms.count
        case .bathrooms:
            return rowsBathroomsType.count
        case .spacesInHouse:
            return rowsSpacesInHouseType.count
        case .condition:
            return rowInCondition.count
        case .editRoom:
            return rowsInEditRoom.count
        }
        
    }
    
    func numberOfSections() -> Int {
        return sections.count
    }
    
    
    func addNewRoom(in section: InteriorRoomsTableSection, at index: Int, cellType: InteriorRoomsCellType,title : String, description : String) {
        switch section {
        case .spacesInHouse:
            let otherRoom = createOtherRoom(name: title, description: description)
            lstOtherNewRooms.append(otherRoom)
            rowsSpacesInHouseType.insert(cellType, at: rowsSpacesInHouseType.count-1)
        default:
            return
        }
    }
    
    func getNewRoomTitle(for row:Int)->String?{
        if(lstOtherNewRooms.count > 0){
            var index = row - fixedRoomCount
            if  lstOtherNewRooms.indices.contains(index)
            {
                return lstOtherNewRooms[index].name
            }
        }
        return ""
    }
    
    func deleteNewRoom(in index:Int){
        do{
            let cellType = rowsSpacesInHouseType[index]
            if cellType == .others{
                let otherRoomToDelete =  lstOtherNewRooms[index - fixedRoomCount]
                
                lstOtherNewRooms.remove(at: index - fixedRoomCount)
                rowsSpacesInHouseType.remove(at: index)
                
                
                if otherRoomToDelete.isNewRoom ?? false == false {
                    deleteRoomList.append(otherRoomToDelete.id)
                }
            }
        }catch
        {
            debugPrint("Cant delete other room element")
        }
    }
    
    
}


extension EIInteriorRoomsControllerViewModel
{
    
    func setDefaults()
    {
        if property?.interiorCondition == nil
        {
            property?.interiorCondition = .good
        }
    }
    
    
}

