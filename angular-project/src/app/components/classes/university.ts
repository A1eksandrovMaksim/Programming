import { IUniversity } from "../models/university";

export class University{
    country: string
    name: string
    domains: string[]
    admition_date: Date
    graduate_date: Date
    pay_condition: string
    debt: number

    constructor(iu: IUniversity){
        this.country = iu.country
        this.name = iu.name
        this.domains = iu.domains.slice(0)
        this.admition_date = new Date(new Date(Date.now()))
        this.graduate_date = new Date()
        this.graduate_date.setDate(this.admition_date.getDate() + Math.trunc(Math.random()*1000));
        const rand:number = Math.trunc((Math.random()*1000)%3)
        switch(rand){
            case 0:
                this.pay_condition = 'Unpaid'
                break
            case 1:
                this.pay_condition = 'Paid'
                break
            case 2:
                this.pay_condition = 'Pending'
                break
        }
        this.debt = Math.random() * 10000
    }
}