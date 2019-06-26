import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment


// source: https://stackoverflow.com/questions/105034/create-guid-uuid-in-javascript
function uuidv4() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  inputUrl: String = "https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml"
  isUploadSuccess: boolean = false;
  submitted: boolean = false;

  constructor(private http: HttpClient,) {}

  ngOnInit() {}

  startValidation() {
    this.submitted = true;
    const body = {
      url: this.inputUrl,
      validationId: uuidv4(),
      socketSessionId: window.sessionStorage.getItem("sessionId")
    }

    this.http.post(`${API_URL}/feed/upload`, body)
      .subscribe((data) => {
        this.isUploadSuccess = data['success'];

        setTimeout(() => {
          this.submitted = false
        }, 3000)
      })
  }

}