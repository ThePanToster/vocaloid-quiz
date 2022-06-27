import { Router } from '@angular/router'
import { Frame } from "@nativescript/core"

export function restartPage(router: Router){
    // Frame.topmost().getViewById("results")
    router.routeReuseStrategy.shouldReuseRoute = () => false
    router.onSameUrlNavigation = 'reload'
    router.navigate(['/game'])
}

export function startGame(router: Router){
    // Frame.topmost().getViewById("results")
    router.routeReuseStrategy.shouldReuseRoute = () => false
    router.onSameUrlNavigation = 'reload'
    router.navigate(['/game'])
}

export function showResults(){
    const resultsElem = Frame.topmost().getViewById("results")

    resultsElem.style.visibility = "visible"
}
// export function viewResults(){
//     Label.getViewById("formString")
// }

