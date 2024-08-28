package com.example.tenantprojectkoala.models

class House {
    var imageUrl:String=""
    var price:String=""
    var size:String=""
    var location:String=""
    var phonenumber:String=""
    var description:String=""
    var id:String=""

    constructor(
        imageUrl: String,
        price: String,
        size: String,
        location: String,
        phonenumber:String,
        description: String,
        id: String,
    ){
        this.imageUrl= imageUrl
        this.price= price
        this.size= size
        this.location= location
        this.phonenumber= phonenumber
        this.description= description
        this.id= id
    }
    constructor()
}