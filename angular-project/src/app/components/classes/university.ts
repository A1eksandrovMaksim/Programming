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
        this.admition_date = new Date(new Date().getDate() + Math.random())
        this.graduate_date = new Date(this.admition_date.getDate() + new Date(4, 0, 0).getDate());
        switch((Math.random()*10)%3){
            case 0:
                this.pay_condition = "Unpaid"
                break
            case 1:
                this.pay_condition = "Paid"
                break
            case 2:
                this.pay_condition = "Pending"
                break
        }
        this.debt = Math.random() * 1000
    }
}