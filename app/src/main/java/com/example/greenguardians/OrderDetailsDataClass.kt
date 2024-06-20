package com.example.greenguardians

class OrderDetailsDataClass{
    var todayDate:String?=null
    var loadCustomerName:String?=null
    var loadCustomerAddress:String?=null
    var loadCustomerPhone:String?=null
    var loadItemName:String?=null
    var loadnumberofItems:String?=null
    constructor(todayDate:String?, loadCustomerName:String?,loadCustomerAddress:String?,loadCustomerPhone:String?,loadItemName:String?,loadnumberofItems:String?)
    {
        this.todayDate = todayDate
        this.loadCustomerName= loadCustomerName
        this.loadCustomerAddress= loadCustomerAddress
        this.loadCustomerPhone= loadCustomerPhone
        this.loadItemName=loadItemName
        this.loadnumberofItems= loadnumberofItems
    }
    constructor()
}