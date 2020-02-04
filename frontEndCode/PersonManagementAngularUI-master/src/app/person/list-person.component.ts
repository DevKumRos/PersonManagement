import { Component, OnInit } from '@angular/core';
import { IPerson } from './IPerson';
import { PersonService } from './person.service';
import { ActivatedRoute, ParamMap, Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})
export class ListPersonComponent implements OnInit {
  persons:IPerson[];
  displayMessage:string;
  constructor(private _personService: PersonService, private route: ActivatedRoute,private router: Router) { 
    console.log("Entered List Person");
    this.displayMessage="";
  }

  ngOnInit() {
 
    this._personService.getPersons().subscribe(
      (personList: IPerson[]) =>{
        this.persons = personList['person'];
        console.log("personList : "+this.persons+" Lenth = "+this.persons.length);
        console.log("this.displayMessage :"+this.displayMessage );
         this.route.paramMap.subscribe((params: ParamMap) => {
          let message = params.get('message');
          if(this.persons.length == 0) {
            message = "No Record Found";  
          } 
          console.log("Enter message section : "+message);
          this.displayMessage = message;
        });
        
      },
      (err) => console.log(err)
    );

  }

  deletePersonById(person: IPerson) {
    this._personService.deletePerson(person.personId).subscribe(
      (response) => {
        this.displayMessage = person.first_name+ " "+person.last_name +" Deleted Successfully";
       /* this.router.routeReuseStrategy.shouldReuseRoute = function () {
          return false;
        };*/
        this.removeObject(person.personId);
        this.router.navigate(['/getAllPerson', {message:this.displayMessage}]);
      },
      (err) => console.log(err)
    );

  }

  removeObject(personId){
    for( var i = 0; i < this.persons.length; i++){ 
        if ( this.persons[i].personId === personId) {
          this.persons.splice(i, 1); 
        }
    }
  }
  getPersonById(person: IPerson) {
    console.log("getPersonById");
    this._personService.getPerson(person.personId).subscribe(
      (response) => {
        let personStr = JSON.stringify(response['person'][0])
        this.router.navigate(['/createPerson', {person:personStr}]);
      },
      (err) => console.log(err)
    );
  }

}
