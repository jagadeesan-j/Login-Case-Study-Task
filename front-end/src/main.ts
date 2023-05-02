import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

throw new Error('White screen, reveal yourself!');

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
