//
//  HomeTableViewController.swift
//  NetworkCallProject
//
//  Created by Timilsina, Nishan on 2/10/20.
//  Copyright © 2020 Timilsina, Nishan. All rights reserved.
//

import UIKit

struct Person{
    var age: Int
    var firstname: String
    var lastname:String
}

class HeadLineTableviewCell: UITableViewCell{
    
    @IBOutlet weak var desLbl: UILabel!
    @IBOutlet weak var TitleLbl: UILabel!
    @IBOutlet weak var ImgImage: UIImageView!
}
class HomeTableViewController: UITableViewController {
    @IBOutlet var mytableView: UITableView!
    
    var list:[Person]=[];
    override func viewDidLoad() {
        
        super.viewDidLoad()
        mytableView.dataSource = self;
        mytableView.delegate = self;
        
       getData();
        mytableView.reloadData();
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }

    
    func getData(){
        
        // Obtain Reference to Shared Session
        let sharedSession = URLSession.shared
        
        if let url = URL(string: "https://learnappmaking.com/ex/users.json") {
            // Create Request
            let request = URLRequest(url: url)
            
            // Create Data Task
            let dataTask = sharedSession.dataTask(with: request, completionHandler: { (data, response, error) -> Void in
                if let data = data {
                    do {
                        let json = try JSONSerialization.jsonObject(with: data, options: [])
                        if let array = json as? NSArray{
                            for obj in array{
                                if let dict = obj as? NSDictionary{
                                    let age = dict.value(forKey: "age");
                                    let firstname = dict.value(forKey: "first_name");
                                    let lastname = dict.value(forKey: "last_name");
                                    let person = Person(age: age as! Int, firstname: firstname as! String, lastname: lastname as! String);
                                    self.list.append(person);
                                }
                            }
                        }
                        print(json)
                    } catch {
                        print("JSON error: \(error.localizedDescription)")
                    }
                    //UI update in main thread
                    DispatchQueue.main.async {
                        self.mytableView.reloadData();
                    }
                }
            })
            
            dataTask.resume()
        }
    }
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return list.count;
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! HeadLineTableviewCell;

        // Configure the cell...
        
        let cellObj = list[indexPath.row];
        cell.TitleLbl.text = cellObj.firstname;
        //cell.desLbl.text = cellObj.lastname;
        
        
        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
