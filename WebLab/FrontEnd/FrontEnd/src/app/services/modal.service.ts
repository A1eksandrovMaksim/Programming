import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  isVisibleAddGroup$ = new BehaviorSubject<boolean>(false);
  isVisibleAddStudent$ = new BehaviorSubject<boolean>(false);
  isVisibleEditGroup$ = new BehaviorSubject<boolean>(false);
  isVisibleEditStudent$ = new BehaviorSubject<boolean>(false);
  isVisibleLogin$ = new BehaviorSubject<boolean>(true);

  openAddGroup(){
    this.isVisibleAddGroup$.next(true)
  }
  openLogin(){
    this.isVisibleLogin$.next(true)
  }
  openAddStudent(){
    this.isVisibleAddStudent$.next(true)
  }
  openEditGroup(){
    this.isVisibleEditGroup$.next(true)
  }
  openEditStudent(){
    this.isVisibleEditStudent$.next(true)
  }

  close(){
    this.isVisibleAddGroup$.next(false)
    this.isVisibleLogin$.next(false)
    this.isVisibleAddStudent$.next(false)
    this.isVisibleEditGroup$.next(false)
    this.isVisibleEditStudent$.next(false)
  }
}
