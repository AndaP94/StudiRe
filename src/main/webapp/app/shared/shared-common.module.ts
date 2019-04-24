import { NgModule } from '@angular/core';

import { StudiReSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [StudiReSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [StudiReSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class StudiReSharedCommonModule {}
