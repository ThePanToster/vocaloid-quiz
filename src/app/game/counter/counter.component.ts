import { Component } from "@angular/core";
import * as GameEngine from "../gameEngine"
import { Router } from '@angular/router'
import { Color, EventData, View } from '@nativescript/core'

@Component({
    selector: "ns-counter",
    templateUrl: "./counter.component.html",
    styleUrls: ["./counter.component.css"],
})
export class CounterComponent {
    text: number = 15;
    constructor(private router: Router) {
        let counting = setInterval(() => {
            if (this.text > 0) this.text -= 1;
            else {
                clearInterval(counting)
                GameEngine.showResults()
            }
        }, 1000);
    }
}
