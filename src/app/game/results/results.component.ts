import { Component } from "@angular/core";

@Component({
    selector: "ns-results",
    templateUrl: "./results.component.html",
    styleUrls: ["./results.component.css"],
})
export class ResultsComponent {
    text: number = 15
    result: string = "Wrong"
    procentage: string = "100%"
    goodAnsw: string = "Good answers: 2137"
    allAnsw: string = "Total answers: 123343"
}
