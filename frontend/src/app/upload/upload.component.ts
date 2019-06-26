import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment

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
