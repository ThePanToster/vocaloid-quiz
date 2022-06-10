import { Router } from '@angular/router'
import { Component } from '@angular/core'
import { KeyframeAnimation, GestureEventData, View } from '@nativescript/core'


@Component({
  selector: 'ns-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent {


  constructor(
    private router: Router
  ) {}

  onTap(args: GestureEventData) {
    const view = args.object as View
    const page = view.page

    const img = page.getViewById('img') as View
    const imgAnimationInfo = page.getKeyframeAnimationWithName('second-left-slide')
    imgAnimationInfo.duration = 2500
    imgAnimationInfo.curve = 'ease'
    imgAnimationInfo.isForwards = true
    const imgAnimation = KeyframeAnimation.keyframeAnimationFromInfo(imgAnimationInfo)

    const title = page.getViewById('title') as View
    const titleAnimationInfo = page.getKeyframeAnimationWithName('second-right-slide')
    titleAnimationInfo.duration = 2500
    titleAnimationInfo.curve = 'ease'
    titleAnimationInfo.isForwards = true
    const titleAnimation = KeyframeAnimation.keyframeAnimationFromInfo(titleAnimationInfo)

    const fader = page.getViewById('fader') as View
    const faderAnimationInfo = page.getKeyframeAnimationWithName('alpha-to-yellow')
    faderAnimationInfo.duration = 2500
    faderAnimationInfo.isForwards = true
    const faderAnimation = KeyframeAnimation.keyframeAnimationFromInfo(faderAnimationInfo)

    const tapper = page.getViewById('tap-to-start') as View
    const tapperAnimationInfo = page.getKeyframeAnimationWithName('second-right-slide')
    tapperAnimationInfo.duration = 2500
    tapperAnimationInfo.isForwards = true
    const tapperAnimation = KeyframeAnimation.keyframeAnimationFromInfo(tapperAnimationInfo)

    imgAnimation.play(img).then(() => {
      this.router.navigate(['/game'])
    })
    titleAnimation.play(title)
    faderAnimation.play(fader)
    tapperAnimation.play(tapper)
  }
}
