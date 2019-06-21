import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  inputUrl: String = "https://bannerwise-assets.s3.eu-central-1.amazonaws.com/xml/benchy.xml"
  isUploadSuccess: boolean = false;
  submitted: boolean = false;

  constructor(private http: HttpClient,) {}

  ngOnInit() {
    console.log('moetje url')
  }

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
