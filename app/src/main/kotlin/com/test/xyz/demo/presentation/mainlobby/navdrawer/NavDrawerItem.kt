package com.test.xyz.demo.presentation.mainlobby.navdrawer

class NavDrawerItem {
    var isShowNotify: Boolean = false
    var title: String? = null

    constructor() {}

    constructor(showNotify: Boolean, title: String) {
        this.isShowNotify = showNotify
        this.title = title
    }
}