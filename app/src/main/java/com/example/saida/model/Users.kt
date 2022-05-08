package com.example.saida.model

data class Users(val id:String,val fn:String,val email:String,val number:String
,val ttl:String,val password:String) {
    constructor():this("","","","","","")
}