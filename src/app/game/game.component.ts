import { Component } from '@angular/core'
import { Router } from '@angular/router'
import { EventData, GestureEventData, View } from '@nativescript/core'
import * as GameEngine from "./gameEngine"
@Component({
  selector: 'ns-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent {
    constructor(private router: Router) {}
    pageLoaded(args: EventData){
        const view = args.object as View
        const page = view.page
        // console.log("zaladowano strone")
    }
    onTap(args: GestureEventData) {
        const view = args.object as View
        const page = view.page
        const resultsElem = page.getViewById("results")

        if(resultsElem.style.visibility != "hidden"){
            GameEngine.restartPage(this.router)
        }
    }
}
