import { Pipe, PipeTransform } from '@angular/core'

@Pipe({
  name: 'transRole'
})
export class TransRolePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    let roleid = value
    if (roleid == 1) return 'ADMIN'
    else if (roleid == 2) return 'USER'
  }

}
