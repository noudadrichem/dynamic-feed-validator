(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _upload_upload_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./upload/upload.component */ "./src/app/upload/upload.component.ts");






var routes = [
    {
        path: 'home',
        component: _home_home_component__WEBPACK_IMPORTED_MODULE_4__["HomeComponent"]
    },
    {
        path: 'upload',
        component: _upload_upload_component__WEBPACK_IMPORTED_MODULE_5__["UploadComponent"]
    },
    {
        path: 'home/:feedid',
        component: _home_home_component__WEBPACK_IMPORTED_MODULE_4__["HomeComponent"]
    },
    {
        path: 'login',
        component: _login_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"]
    },
    {
        path: '**',
        redirectTo: 'login',
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"page\">\n  <router-outlet (uploadedFeed)=\"listenToUploadedFeed()\"></router-outlet>\n</div>"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".page {\n  font-family: 'Nunito', sans-serif;\n  display: -webkit-flex;\n  display: flex; }\n  .page * {\n    box-sizing: border-box;\n    padding: 0;\n    margin: 0; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvYXBwLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsaUNBQWlDO0VBQ2pDLHFCQUFhO0VBQWIsYUFBYSxFQUFBO0VBRmY7SUFLSSxzQkFBc0I7SUFDdEIsVUFBVTtJQUNWLFNBQVMsRUFBQSIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi5wYWdlIHtcbiAgZm9udC1mYW1pbHk6ICdOdW5pdG8nLCBzYW5zLXNlcmlmO1xuICBkaXNwbGF5OiBmbGV4O1xuXG4gICoge1xuICAgIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XG4gICAgcGFkZGluZzogMDtcbiAgICBtYXJnaW46IDA7XG4gIH1cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent.prototype.listenToUploadedFeed = function () {
        console.log('feed has beeen uploaded a zabii');
    };
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var ngx_socket_io__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ngx-socket-io */ "./node_modules/ngx-socket-io/index.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./sidebar/sidebar.component */ "./src/app/sidebar/sidebar.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _container_container_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./container/container.component */ "./src/app/container/container.component.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _upload_upload_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./upload/upload.component */ "./src/app/upload/upload.component.ts");
/* harmony import */ var _card_card_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./card/card.component */ "./src/app/card/card.component.ts");
/* harmony import */ var _card_container_card_container_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./card-container/card-container.component */ "./src/app/card-container/card-container.component.ts");
/* harmony import */ var _settings_settings_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./settings/settings.component */ "./src/app/settings/settings.component.ts");
















var socketConfig = {
    url: 'http://localhost:9090/api/feed/subscribe'
};
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_7__["AppComponent"],
                _sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_8__["SidebarComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_9__["LoginComponent"],
                _container_container_component__WEBPACK_IMPORTED_MODULE_10__["ContainerComponent"],
                _home_home_component__WEBPACK_IMPORTED_MODULE_11__["HomeComponent"],
                _upload_upload_component__WEBPACK_IMPORTED_MODULE_12__["UploadComponent"],
                _card_card_component__WEBPACK_IMPORTED_MODULE_13__["CardComponent"],
                _card_container_card_container_component__WEBPACK_IMPORTED_MODULE_14__["CardContainerComponent"],
                _settings_settings_component__WEBPACK_IMPORTED_MODULE_15__["SettingsComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_6__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                ngx_socket_io__WEBPACK_IMPORTED_MODULE_5__["SocketIoModule"].forRoot(socketConfig)
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_7__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/card-container/card-container.component.html":
/*!**************************************************************!*\
  !*** ./src/app/card-container/card-container.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"card-container\">\n  <div class=\"errors\">\n    <h3>Errors (total: {{ errors.length }})</h3>\n\n    <ul *ngIf=\"isErrorsShown\">\n      <li *ngFor=\"let error of errors\">\n        <card \n          [title]=\"error.title\" \n          [description]=\"error.description\"\n          [type]=\"error.type\"\n          [productId]=\"error.productId\">\n        </card>\n      </li>\n    </ul>\n  </div>\n\n  <div class=\"warnings\">\n    <h3>Warnings (total: {{ warnings.length }})</h3>\n\n    <ul *ngIf=\"isWarningsShown\">\n      <li *ngFor=\"let warning of warnings\">\n        <card \n          [title]=\"warning.title\" \n          [description]=\"warning.description\"\n          [type]=\"warning.type\"\n          [productId]=\"warning.productId\">\n        </card>\n      </li>\n    </ul>\n  </div>\n\n</div>"

/***/ }),

/***/ "./src/app/card-container/card-container.component.scss":
/*!**************************************************************!*\
  !*** ./src/app/card-container/card-container.component.scss ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NhcmQtY29udGFpbmVyL2NhcmQtY29udGFpbmVyLmNvbXBvbmVudC5zY3NzIn0= */"

/***/ }),

/***/ "./src/app/card-container/card-container.component.ts":
/*!************************************************************!*\
  !*** ./src/app/card-container/card-container.component.ts ***!
  \************************************************************/
/*! exports provided: CardContainerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CardContainerComponent", function() { return CardContainerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var CardContainerComponent = /** @class */ (function () {
    function CardContainerComponent() {
    }
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], CardContainerComponent.prototype, "errors", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], CardContainerComponent.prototype, "warnings", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Boolean)
    ], CardContainerComponent.prototype, "isErrorsShown", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Boolean)
    ], CardContainerComponent.prototype, "isWarningsShown", void 0);
    CardContainerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'card-container',
            template: __webpack_require__(/*! ./card-container.component.html */ "./src/app/card-container/card-container.component.html"),
            styles: [__webpack_require__(/*! ./card-container.component.scss */ "./src/app/card-container/card-container.component.scss")]
        })
    ], CardContainerComponent);
    return CardContainerComponent;
}());



/***/ }),

/***/ "./src/app/card/card.component.html":
/*!******************************************!*\
  !*** ./src/app/card/card.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div [ngClass]=\"['card', type]\">\n  <div (click)=\"toggleDescription()\" class=\"chevron\">\n    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-linecap=\"square\" stroke-linejoin=\"bevel\"><path d=\"M6 9l6 6 6-6\"/></svg>\n  </div>\n\n  <div>\n    <p class=\"title\">{{title}}</p>\n    <p *ngIf=\"isDescriptionShown\" class=\"description\">{{ description }}</p>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/card/card.component.scss":
/*!******************************************!*\
  !*** ./src/app/card/card.component.scss ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".card {\n  display: -webkit-flex;\n  display: flex;\n  margin-bottom: 12px;\n  border-radius: 4px;\n  padding: 8px; }\n  .card.error {\n    border: 1px solid #F71B39;\n    background-color: #FFFBFC; }\n  .card.warning {\n    border: 1px solid #F79C1B;\n    background-color: #FEFCF9; }\n  .card .chevron {\n    cursor: pointer;\n    margin-right: 8px;\n    -webkit-transform: translateY(2px);\n            transform: translateY(2px); }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvY2FyZC9jYXJkLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UscUJBQWE7RUFBYixhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLGtCQUFrQjtFQUNsQixZQUFZLEVBQUE7RUFKZDtJQU9JLHlCQUF5QjtJQUN6Qix5QkFBeUIsRUFBQTtFQVI3QjtJQVlJLHlCQUF5QjtJQUN6Qix5QkFBeUIsRUFBQTtFQWI3QjtJQWlCSSxlQUFlO0lBQ2YsaUJBQWlCO0lBQ2pCLGtDQUEwQjtZQUExQiwwQkFBMEIsRUFBQSIsImZpbGUiOiJzcmMvYXBwL2NhcmQvY2FyZC5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi5jYXJkIHtcbiAgZGlzcGxheTogZmxleDtcbiAgbWFyZ2luLWJvdHRvbTogMTJweDtcbiAgYm9yZGVyLXJhZGl1czogNHB4O1xuICBwYWRkaW5nOiA4cHg7XG5cbiAgJi5lcnJvciB7XG4gICAgYm9yZGVyOiAxcHggc29saWQgI0Y3MUIzOTtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjRkZGQkZDO1xuICB9XG5cbiAgJi53YXJuaW5nIHtcbiAgICBib3JkZXI6IDFweCBzb2xpZCAjRjc5QzFCO1xuICAgIGJhY2tncm91bmQtY29sb3I6ICNGRUZDRjk7XG4gIH1cblxuICAuY2hldnJvbiB7XG4gICAgY3Vyc29yOiBwb2ludGVyO1xuICAgIG1hcmdpbi1yaWdodDogOHB4O1xuICAgIHRyYW5zZm9ybTogdHJhbnNsYXRlWSgycHgpO1xuICB9XG59Il19 */"

/***/ }),

/***/ "./src/app/card/card.component.ts":
/*!****************************************!*\
  !*** ./src/app/card/card.component.ts ***!
  \****************************************/
/*! exports provided: CardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CardComponent", function() { return CardComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var CardComponent = /** @class */ (function () {
    function CardComponent() {
        this.isDescriptionShown = false;
    }
    CardComponent.prototype.toggleDescription = function () {
        console.log('toggleDescription');
        this.isDescriptionShown = !this.isDescriptionShown;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], CardComponent.prototype, "title", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], CardComponent.prototype, "description", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], CardComponent.prototype, "type", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], CardComponent.prototype, "productId", void 0);
    CardComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'card',
            template: __webpack_require__(/*! ./card.component.html */ "./src/app/card/card.component.html"),
            styles: [__webpack_require__(/*! ./card.component.scss */ "./src/app/card/card.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CardComponent);
    return CardComponent;
}());



/***/ }),

/***/ "./src/app/container/container.component.html":
/*!****************************************************!*\
  !*** ./src/app/container/container.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  container works!\n</p>\n"

/***/ }),

/***/ "./src/app/container/container.component.scss":
/*!****************************************************!*\
  !*** ./src/app/container/container.component.scss ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbnRhaW5lci9jb250YWluZXIuY29tcG9uZW50LnNjc3MifQ== */"

/***/ }),

/***/ "./src/app/container/container.component.ts":
/*!**************************************************!*\
  !*** ./src/app/container/container.component.ts ***!
  \**************************************************/
/*! exports provided: ContainerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContainerComponent", function() { return ContainerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ContainerComponent = /** @class */ (function () {
    function ContainerComponent() {
    }
    ContainerComponent.prototype.ngOnInit = function () {
    };
    ContainerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-container',
            template: __webpack_require__(/*! ./container.component.html */ "./src/app/container/container.component.html"),
            styles: [__webpack_require__(/*! ./container.component.scss */ "./src/app/container/container.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ContainerComponent);
    return ContainerComponent;
}());



/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<sidebar></sidebar>\n<div class=\"home\" *ngIf=\"isFeedIsSelected\">\n  <header>\n    <span>\n      <h1>{{ feed.title }}</h1>\n    </span>\n\n    <div class=\"filters\">\n      <div class=\"filters-content\">\n        <label>filters:</label>\n        <ul class=\"ui secondary pointing menu\">\n          <li [ngClass]=\"['item', isErrorsShown && isWarningsShown ? 'active' : '']\" (click)=\"showAllMessages()\">show all</li>\n          <li [ngClass]=\"['item', isErrorsShown && !isWarningsShown ? 'active' : '']\" (click)=\"showErrors()\">errors</li>\n          <li [ngClass]=\"['item', !isErrorsShown && isWarningsShown? 'active' : '']\" (click)=\"showWarnings()\">warnings</li>\n        </ul>\n        <div class=\"settings\" (click)=\"showSettingsModal()\">\n          <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#93959B\" stroke-width=\"2\" stroke-linecap=\"square\" stroke-linejoin=\"bevel\"><line x1=\"4\" y1=\"21\" x2=\"4\" y2=\"14\"></line><line x1=\"4\" y1=\"10\" x2=\"4\" y2=\"3\"></line><line x1=\"12\" y1=\"21\" x2=\"12\" y2=\"12\"></line><line x1=\"12\" y1=\"8\" x2=\"12\" y2=\"3\"></line><line x1=\"20\" y1=\"21\" x2=\"20\" y2=\"16\"></line><line x1=\"20\" y1=\"12\" x2=\"20\" y2=\"3\"></line><line x1=\"1\" y1=\"14\" x2=\"7\" y2=\"14\"></line><line x1=\"9\" y1=\"8\" x2=\"15\" y2=\"8\"></line><line x1=\"17\" y1=\"16\" x2=\"23\" y2=\"16\"></line></svg>\n        </div>\n      </div>\n    </div>\n  </header>\n\n  <div class=\"container\">\n    <div class=\"ui message success\" *ngIf=\"errors.length === 0 && warnings.length === 0\">\n      Well done, no errors found!\n    </div>\n\n    <card-container\n      *ngIf=\"errors.length > 0 && warnings.length > 0\"\n      [errors]=\"errors\"\n      [warnings]=\"warnings\"\n      [isErrorsShown]=\"isErrorsShown\"\n      [isWarningsShown]=\"isWarningsShown\">\n    </card-container>\n  </div>\n\n  <settings\n    *ngIf=\"isSettingsIsShown\"\n    (emitter)=\"hideSettingsModal($event)\"\n    [feedId]=\"feed.id\"\n    [totalAmount]=\"errors.length + warnings.length\"\n  ></settings>\n\n</div>"

/***/ }),

/***/ "./src/app/home/home.component.scss":
/*!******************************************!*\
  !*** ./src/app/home/home.component.scss ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".home {\n  margin-left: 280px; }\n  .home ul {\n    padding: 0;\n    list-style: none; }\n  .home header .filters {\n    display: -webkit-inline-flex;\n    display: inline-flex;\n    -webkit-flex-direction: column;\n            flex-direction: column; }\n  .home header .filters-content {\n      display: -webkit-flex;\n      display: flex;\n      -webkit-align-items: center;\n              align-items: center; }\n  .home header .filters ul li {\n      padding: 8px 12px;\n      margin: 0 4px;\n      font-size: 14px; }\n  .home .settings {\n    padding-top: 8px;\n    margin-left: 16px; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvaG9tZS9ob21lLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usa0JBQWtCLEVBQUE7RUFEcEI7SUFJSSxVQUFVO0lBQ1YsZ0JBQWdCLEVBQUE7RUFMcEI7SUFVTSw0QkFBb0I7SUFBcEIsb0JBQW9CO0lBQ3BCLDhCQUFzQjtZQUF0QixzQkFBc0IsRUFBQTtFQVg1QjtNQWNRLHFCQUFhO01BQWIsYUFBYTtNQUNiLDJCQUFtQjtjQUFuQixtQkFBbUIsRUFBQTtFQWYzQjtNQW9CVSxpQkFBaUI7TUFDakIsYUFBYTtNQUNiLGVBQWUsRUFBQTtFQXRCekI7SUE2QkksZ0JBQWdCO0lBQ2hCLGlCQUFpQixFQUFBIiwiZmlsZSI6InNyYy9hcHAvaG9tZS9ob21lLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmhvbWUge1xuICBtYXJnaW4tbGVmdDogMjgwcHg7XG5cbiAgdWwge1xuICAgIHBhZGRpbmc6IDA7XG4gICAgbGlzdC1zdHlsZTogbm9uZTtcbiAgfVxuICBcbiAgaGVhZGVyIHtcbiAgICAuZmlsdGVycyB7XG4gICAgICBkaXNwbGF5OiBpbmxpbmUtZmxleDtcbiAgICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG5cbiAgICAgICYtY29udGVudCB7XG4gICAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgICB9XG5cbiAgICAgIHVsIHtcbiAgICAgICAgbGkge1xuICAgICAgICAgIHBhZGRpbmc6IDhweCAxMnB4O1xuICAgICAgICAgIG1hcmdpbjogMCA0cHg7XG4gICAgICAgICAgZm9udC1zaXplOiAxNHB4O1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuICB9XG5cbiAgLnNldHRpbmdzIHtcbiAgICBwYWRkaW5nLXRvcDogOHB4O1xuICAgIG1hcmdpbi1sZWZ0OiAxNnB4O1xuICB9XG59Il19 */"

/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./../../environments/environment */ "./src/environments/environment.ts");





var API_URL = _environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].API_URL;
var HomeComponent = /** @class */ (function () {
    function HomeComponent(http, route) {
        this.http = http;
        this.route = route;
        this.feed = {};
        this.errors = [];
        this.warnings = [];
        this.isFeedIsSelected = false;
        this.isErrorsShown = true;
        this.isWarningsShown = true;
        this.isSettingsIsShown = false;
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.paramMap.subscribe(function (params) {
            var feedId = params.get('feedid');
            if (feedId !== null) {
                _this.getSelectedFeed(feedId);
                _this.isFeedIsSelected = true;
            }
        });
    };
    HomeComponent.prototype.getSelectedFeed = function (feedId) {
        var _this = this;
        this.http.get(API_URL + "/feed/" + feedId)
            .subscribe(function (feed) {
            _this.feed = feed;
            _this.errors = _this.feed.messages.filter(function (m) { return m.type === 'error'; });
            _this.warnings = _this.feed.messages.filter(function (m) { return m.type === 'warning'; });
        });
    };
    HomeComponent.prototype.showErrors = function () {
        this.isErrorsShown = true;
        this.isWarningsShown = false;
    };
    HomeComponent.prototype.showWarnings = function () {
        this.isWarningsShown = true;
        this.isErrorsShown = false;
    };
    HomeComponent.prototype.showAllMessages = function () {
        this.isErrorsShown = true;
        this.isWarningsShown = true;
    };
    HomeComponent.prototype.hideSettingsModal = function () {
        console.log('hide');
        this.isSettingsIsShown = false;
    };
    HomeComponent.prototype.showSettingsModal = function () {
        console.log('show');
        this.isSettingsIsShown = true;
    };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.scss */ "./src/app/home/home.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"login\">\n\n  <div class=\"ui login floated middle center card\">\n    <div class=\"header\">\n      <h1>Login</h1>\n    </div>\n    <div class=\"content\">\n      <form class=\"ui form\" id=\"loginForm\" name=\"loginForm\"\n        ng-submit=\"login(loginForm, formData)\">\n        <div class=\"field\">\n          <label>Email</label>\n          <div class=\"ui input\">\n            <input type=\"email\" name=\"email\" value=\"info@noudadrichem.com\" placeholder=\"Enter your email...\" class=\"ng-pristine ng-untouched ng-valid-email ng-invalid ng-invalid-required\">\n          </div>\n        </div>\n        <div class=\"field\"><label>Password</label>\n          <div class=\"ui input\" password=\"\">\n            <input type=\"password\" name=\"password\" placeholder=\"Enter your password...\" tabindex=\"2\" required=\"\" class=\"ng-pristine ng-untouched ng-invalid ng-invalid-required\">\n          </div>\n        </div>\n        <a class=\"ui success fluid button\" [routerLink]=\"['/home']\" type=\"submit\" ng-class=\"{ 'loading': loading }\">Log in</a>\n      </form>\n    </div>\n  </div>\n\n\n</div>\n"

/***/ }),

/***/ "./src/app/login/login.component.scss":
/*!********************************************!*\
  !*** ./src/app/login/login.component.scss ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5zY3NzIn0= */"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var LoginComponent = /** @class */ (function () {
    function LoginComponent() {
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.scss */ "./src/app/login/login.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/services/feed-http.service.ts":
/*!***********************************************!*\
  !*** ./src/app/services/feed-http.service.ts ***!
  \***********************************************/
/*! exports provided: FeedHttpService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FeedHttpService", function() { return FeedHttpService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");




var API_URL = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].API_URL;
var FeedHttpService = /** @class */ (function () {
    function FeedHttpService(http) {
        this.http = http;
    }
    FeedHttpService.prototype.uploadFeedUrl = function (body) {
        return this.http.post(API_URL + "/feed/upload", body);
    };
    FeedHttpService.prototype.getSelectedFeed = function (feedId) {
        return this.http.get(API_URL + "/feed/" + feedId);
    };
    FeedHttpService.prototype.fetchFeeds = function () {
        return this.http.get(API_URL + "/feed/all");
    };
    FeedHttpService.prototype.deleteFeed = function (feedId) {
        return this.http.delete(API_URL + "/feed/delete/" + feedId);
    };
    FeedHttpService.prototype.fetchFeedBluePrint = function (feedId) {
        return this.http.get(API_URL + "/blueprint/" + feedId);
    };
    FeedHttpService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], FeedHttpService);
    return FeedHttpService;
}());



/***/ }),

/***/ "./src/app/services/feed-model.service.ts":
/*!************************************************!*\
  !*** ./src/app/services/feed-model.service.ts ***!
  \************************************************/
/*! exports provided: FeedModelService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FeedModelService", function() { return FeedModelService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");



var FeedModelService = /** @class */ (function () {
    function FeedModelService() {
        this.subject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Subject"]();
        this.feeds = [];
    }
    FeedModelService.prototype.onFeedUpdate = function () {
        console.log('on update feed model service');
        return this.subject.asObservable();
    };
    FeedModelService.prototype.trigger = function () {
        console.log('trigger feed model service');
        this.subject.next();
    };
    FeedModelService.prototype.getFeeds = function () {
        return this.feeds;
    };
    FeedModelService.prototype.pushFeed = function (feed) {
        this.feeds.push(feed);
    };
    FeedModelService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FeedModelService);
    return FeedModelService;
}());



/***/ }),

/***/ "./src/app/settings/settings.component.html":
/*!**************************************************!*\
  !*** ./src/app/settings/settings.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal\">\n  <div class=\"ui dimmer visible active\">\n    <div class=\"ui manage modal flex vertical transition visible active\">\n      <div class=\"header\">\n        <div class=\"close\">\n          <svg (click)=\"hideModal()\" xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-linecap=\"square\" stroke-linejoin=\"bevel\"><line x1=\"12\" y1=\"5\" x2=\"12\" y2=\"19\"></line><line x1=\"5\" y1=\"12\" x2=\"19\" y2=\"12\"></line></svg>\n        </div>\n        <h1 class=\"ng-binding\">Settings</h1>\n        <p>{{ feedId }}</p>\n      </div>\n      <div class=\"content flex display\">\n        <div class=\"ui grid\">\n          <div class=\"six wide column\">\n            <div>\n              <label>Total messages:</label>\n              {{ totalAmount }}\n            </div>\n            <div class=\"delete-feed-btn\">\n              <button class=\"ui button primary small\" (click)=\"isDeleteFeedShown = true\" *ngIf=\"!isDeleteFeedShown\">Delete feed</button>\n              <button class=\"ui button danger small\" (click)=\"deleteFeed()\" *ngIf=\"isDeleteFeedShown\">You sure?</button>\n            </div>\n            <div>\n              <button class=\"ui button primary small\">Revalidate</button>\n            </div>\n          </div>\n          <div class=\"six wide column\">\n            <div>\n              <label>Blueprint:</label>\n              <!-- <p>A blueprint shows all the used keys inside a product of a feed. This blueprint is used to validate on key/value pairs.</p> -->\n              <ul>\n                <li *ngFor=\"let key of keys\">{{ key }}</li>\n              </ul>\n            </div>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/settings/settings.component.scss":
/*!**************************************************!*\
  !*** ./src/app/settings/settings.component.scss ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".modal .header .close {\n  float: right;\n  -webkit-transform: rotate(45deg);\n          transform: rotate(45deg); }\n\n.modal .content {\n  padding: 24px;\n  -webkit-justify-content: center;\n          justify-content: center;\n  overflow-y: auto !important; }\n\n.modal .content .ui.grid {\n    width: 100%;\n    margin: 0; }\n\n.modal .content .ui.grid .delete-feed-btn {\n      margin-bottom: 12px; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvc2V0dGluZ3Mvc2V0dGluZ3MuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFHTSxZQUFZO0VBQ1osZ0NBQXdCO1VBQXhCLHdCQUF3QixFQUFBOztBQUo5QjtFQVNJLGFBQWE7RUFDYiwrQkFBdUI7VUFBdkIsdUJBQXVCO0VBQ3ZCLDJCQUEyQixFQUFBOztBQVgvQjtJQWNNLFdBQVc7SUFDWCxTQUFTLEVBQUE7O0FBZmY7TUFrQlEsbUJBQW1CLEVBQUEiLCJmaWxlIjoic3JjL2FwcC9zZXR0aW5ncy9zZXR0aW5ncy5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi5tb2RhbCB7XG4gIC5oZWFkZXIge1xuICAgIC5jbG9zZSB7XG4gICAgICBmbG9hdDogcmlnaHQ7XG4gICAgICB0cmFuc2Zvcm06IHJvdGF0ZSg0NWRlZyk7XG4gICAgfVxuICB9XG5cbiAgLmNvbnRlbnQgIHtcbiAgICBwYWRkaW5nOiAyNHB4O1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIG92ZXJmbG93LXk6IGF1dG8gIWltcG9ydGFudDtcblxuICAgIC51aS5ncmlkIHtcbiAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgbWFyZ2luOiAwO1xuXG4gICAgICAuZGVsZXRlLWZlZWQtYnRuIHtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogMTJweDtcbiAgICAgIH1cbiAgICB9XG4gIH1cbn0iXX0= */"

/***/ }),

/***/ "./src/app/settings/settings.component.ts":
/*!************************************************!*\
  !*** ./src/app/settings/settings.component.ts ***!
  \************************************************/
/*! exports provided: SettingsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SettingsComponent", function() { return SettingsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_feed_http_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/feed-http.service */ "./src/app/services/feed-http.service.ts");




var SettingsComponent = /** @class */ (function () {
    function SettingsComponent(feedHttpService, router) {
        this.feedHttpService = feedHttpService;
        this.router = router;
        this.emitter = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.keys = [];
        this.isDeleteFeedShown = false;
    }
    SettingsComponent.prototype.ngOnInit = function () {
        this.fetchBluePrint();
    };
    SettingsComponent.prototype.hideModal = function () {
        this.emitter.emit(false);
    };
    SettingsComponent.prototype.deleteFeed = function () {
        var _this = this;
        this.feedHttpService.deleteFeed(this.feedId)
            .subscribe(function (data) {
            console.log(data);
            _this.router.navigate(['/upload']);
        });
    };
    SettingsComponent.prototype.fetchBluePrint = function () {
        var _this = this;
        this.feedHttpService.fetchFeedBluePrint(this.feedId)
            .subscribe(function (blueprintData) {
            _this.keys = blueprintData['keys'];
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], SettingsComponent.prototype, "feedId", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], SettingsComponent.prototype, "totalAmount", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SettingsComponent.prototype, "emitter", void 0);
    SettingsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'settings',
            template: __webpack_require__(/*! ./settings.component.html */ "./src/app/settings/settings.component.html"),
            styles: [__webpack_require__(/*! ./settings.component.scss */ "./src/app/settings/settings.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_feed_http_service__WEBPACK_IMPORTED_MODULE_3__["FeedHttpService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], SettingsComponent);
    return SettingsComponent;
}());



/***/ }),

/***/ "./src/app/sidebar/sidebar.component.html":
/*!************************************************!*\
  !*** ./src/app/sidebar/sidebar.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"sidebar\">\n  <div class=\"logo\">\n    <img src=\"https://www.bannerwise.io/hubfs/www/bannerwise.svg\" alt=\"Bannerwise logo\">\n  </div>\n  \n  <div class=\"new-validation\">\n    <a [routerLink]=\"['/upload']\" class=\"ui success button\">Validate feed</a>\n  </div>\n\n  <div class=\"feed-list\">\n    <label>Your feeds:</label>\n    <ul>\n      <li *ngFor=\"let feed of feeds\" [ngClass]=\"[feed.id === currentlySelectedFeed ? 'active' : 'not-active']\">\n        <a [routerLink]=\"['/home', feed.id]\">{{ feed.title }}</a>\n\n        <!-- <div *ngIf=\"feed.id === currentlySelectedFeed\" class=\"delete\" (click)=\"deleteFeed(feed.id)\">\n          <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-linecap=\"square\" stroke-linejoin=\"bevel\"><circle cx=\"12\" cy=\"12\" r=\"10\"></circle><line x1=\"15\" y1=\"9\" x2=\"9\" y2=\"15\"></line><line x1=\"9\" y1=\"9\" x2=\"15\" y2=\"15\"></line></svg>\n        </div> -->\n      </li>\n    </ul>\n  </div>\n\n  <div class=\"sidebar-footer\">\n    <a [routerLink]=\"['/login']\" class=\"logout\">\n      <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-linecap=\"square\" stroke-linejoin=\"bevel\"><path d=\"M10 3H6a2 2 0 0 0-2 2v14c0 1.1.9 2 2 2h4M16 17l5-5-5-5M19.8 12H9\"/></svg>\n    </a>\n  </div>\n\n</div>"

/***/ }),

/***/ "./src/app/sidebar/sidebar.component.scss":
/*!************************************************!*\
  !*** ./src/app/sidebar/sidebar.component.scss ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidebar {\n  height: 100vh;\n  position: fixed;\n  left: 0;\n  top: 0;\n  width: 280px;\n  display: -webkit-flex;\n  display: flex;\n  -webkit-flex-direction: column;\n          flex-direction: column;\n  box-shadow: 1px 0 0 0 #EDF0F3;\n  background-color: #F8F9FB;\n  padding: 40px 24px 8px;\n  -webkit-justify-content: space-between;\n          justify-content: space-between; }\n  .sidebar .new-validation {\n    margin-top: 32px; }\n  .sidebar .new-validation a {\n      -webkit-flex: 1;\n              flex: 1;\n      display: -webkit-flex;\n      display: flex;\n      -webkit-justify-content: center;\n              justify-content: center; }\n  .sidebar .feed-list {\n    padding: 40px 0 24px;\n    -webkit-flex: 1;\n            flex: 1; }\n  .sidebar .feed-list ul li {\n      color: #BABABA;\n      list-style: none;\n      display: -webkit-flex;\n      display: flex;\n      -webkit-align-items: center;\n              align-items: center;\n      -webkit-justify-content: space-between;\n              justify-content: space-between;\n      position: relative; }\n  .sidebar .feed-list ul li .kebab-menu-expanded {\n        position: absolute;\n        right: 0;\n        top: 0; }\n  .sidebar .feed-list ul li.active {\n        color: #3E3E3E;\n        list-style: circle; }\n  .sidebar .feed-list ul li a {\n        text-decoration: none;\n        color: currentColor; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvc2lkZWJhci9zaWRlYmFyLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBYTtFQUNiLGVBQWU7RUFDZixPQUFPO0VBQ1AsTUFBSztFQUNMLFlBQVk7RUFDWixxQkFBYTtFQUFiLGFBQWE7RUFDYiw4QkFBc0I7VUFBdEIsc0JBQXNCO0VBQ3RCLDZCQUE2QjtFQUM3Qix5QkFBeUI7RUFDekIsc0JBQXNCO0VBQ3RCLHNDQUE4QjtVQUE5Qiw4QkFBOEIsRUFBQTtFQVhoQztJQWNJLGdCQUFnQixFQUFBO0VBZHBCO01BaUJNLGVBQU87Y0FBUCxPQUFPO01BQ1AscUJBQWE7TUFBYixhQUFhO01BQ2IsK0JBQXVCO2NBQXZCLHVCQUF1QixFQUFBO0VBbkI3QjtJQXdCSSxvQkFBb0I7SUFDcEIsZUFBTztZQUFQLE9BQU8sRUFBQTtFQXpCWDtNQTRCTSxjQUFjO01BQ2QsZ0JBQWdCO01BQ2hCLHFCQUFhO01BQWIsYUFBYTtNQUNiLDJCQUFtQjtjQUFuQixtQkFBbUI7TUFDbkIsc0NBQThCO2NBQTlCLDhCQUE4QjtNQUM5QixrQkFBa0IsRUFBQTtFQWpDeEI7UUFvQ1Esa0JBQWtCO1FBQ2xCLFFBQVE7UUFDUixNQUFNLEVBQUE7RUF0Q2Q7UUEwQ1EsY0FBYztRQUNkLGtCQUFrQixFQUFBO0VBM0MxQjtRQStDUSxxQkFBcUI7UUFDckIsbUJBQW1CLEVBQUEiLCJmaWxlIjoic3JjL2FwcC9zaWRlYmFyL3NpZGViYXIuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuc2lkZWJhciB7XG4gIGhlaWdodDogMTAwdmg7XG4gIHBvc2l0aW9uOiBmaXhlZDtcbiAgbGVmdDogMDtcbiAgdG9wOjA7XG4gIHdpZHRoOiAyODBweDtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgYm94LXNoYWRvdzogMXB4IDAgMCAwICNFREYwRjM7XG4gIGJhY2tncm91bmQtY29sb3I6ICNGOEY5RkI7XG4gIHBhZGRpbmc6IDQwcHggMjRweCA4cHg7XG4gIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcblxuICAubmV3LXZhbGlkYXRpb24ge1xuICAgIG1hcmdpbi10b3A6IDMycHg7XG5cbiAgICBhIHtcbiAgICAgIGZsZXg6IDE7XG4gICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgfVxuICB9XG5cbiAgLmZlZWQtbGlzdCB7XG4gICAgcGFkZGluZzogNDBweCAwIDI0cHg7XG4gICAgZmxleDogMTtcblxuICAgIHVsIGxpIHtcbiAgICAgIGNvbG9yOiAjQkFCQUJBO1xuICAgICAgbGlzdC1zdHlsZTogbm9uZTtcbiAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgICAgcG9zaXRpb246IHJlbGF0aXZlO1xuXG4gICAgICAua2ViYWItbWVudS1leHBhbmRlZCB7XG4gICAgICAgIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgICAgICAgcmlnaHQ6IDA7XG4gICAgICAgIHRvcDogMDtcbiAgICAgIH1cblxuICAgICAgJi5hY3RpdmUge1xuICAgICAgICBjb2xvcjogIzNFM0UzRTtcbiAgICAgICAgbGlzdC1zdHlsZTogY2lyY2xlO1xuICAgICAgfVxuXG4gICAgICBhIHtcbiAgICAgICAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xuICAgICAgICBjb2xvcjogY3VycmVudENvbG9yO1xuICAgICAgfVxuICAgIH1cbiAgfVxufSJdfQ== */"

/***/ }),

/***/ "./src/app/sidebar/sidebar.component.ts":
/*!**********************************************!*\
  !*** ./src/app/sidebar/sidebar.component.ts ***!
  \**********************************************/
/*! exports provided: SidebarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SidebarComponent", function() { return SidebarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_feed_http_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/feed-http.service */ "./src/app/services/feed-http.service.ts");
/* harmony import */ var _services_feed_model_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/feed-model.service */ "./src/app/services/feed-model.service.ts");





var SidebarComponent = /** @class */ (function () {
    function SidebarComponent(route, feedHttpService, feedModelService) {
        this.route = route;
        this.feedHttpService = feedHttpService;
        this.feedModelService = feedModelService;
        this.feeds = [];
        this.currentlySelectedFeed = "";
    }
    SidebarComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.fetchFeeds();
        this.feedModelService.onFeedUpdate()
            .subscribe(function (data) {
            _this.fetchFeeds();
        });
    };
    SidebarComponent.prototype.fetchFeeds = function () {
        var _this = this;
        this.feedHttpService.fetchFeeds()
            .subscribe(function (allFeeds) {
            _this.feeds = allFeeds;
        });
        this.route.paramMap.subscribe(function (params) { return _this.currentlySelectedFeed = params.get('feedid'); });
    };
    SidebarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'sidebar',
            template: __webpack_require__(/*! ./sidebar.component.html */ "./src/app/sidebar/sidebar.component.html"),
            styles: [__webpack_require__(/*! ./sidebar.component.scss */ "./src/app/sidebar/sidebar.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            _services_feed_http_service__WEBPACK_IMPORTED_MODULE_3__["FeedHttpService"],
            _services_feed_model_service__WEBPACK_IMPORTED_MODULE_4__["FeedModelService"]])
    ], SidebarComponent);
    return SidebarComponent;
}());



/***/ }),

/***/ "./src/app/upload/upload.component.html":
/*!**********************************************!*\
  !*** ./src/app/upload/upload.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<sidebar (uploadedFeed)=\"console.log('moetje uploaded feed?')\"></sidebar>\n<div class=\"upload\">\n  <header>\n    <h1>Validate your feed</h1>\n    <div [ngClass]=\"['pulse', connected ? 'green' : 'red']\"></div>\n  </header>\n\n  <div class=\"container\">\n    <div class=\"upload-container\">\n      <span class=\"input\">\n        <label for=\"url-input\">Feed url:</label>\n        <div class=\"ui input stretch\">\n          <input [(ngModel)]=\"inputUrl\">\n        </div>\n      </span>\n      <button [disabled]=\"!connected\" class=\"ui primary button\" (click)=\"startValidation()\">Start validation</button>\n    </div>\n\n    <div *ngIf=\"isUploadSuccess && submitted\" class=\"ui message success\">\n      <p>Feed validation succesfully started...</p>\n    </div>\n    <div *ngIf=\"!isUploadSuccess && submitted\" class=\"ui message failure\">\n      <p>There has been a failure uploading your feed URL</p>\n    </div>\n  </div>\n\n  <div class=\"container\" *ngIf=\"errors.length > 0 || warnings.length > 0\">\n    <card-container \n      [errors]=\"errors\" \n      [warnings]=\"warnings\"\n      [isErrorsShown]=\"true\"\n      [isWarningsShown]=\"true\">\n    </card-container>\n  \n    <div class=\"loading dot-wrapper\" *ngIf=\"stilValidating\">\n      <div class=\"dot\"></div>\n      <div class=\"dot\"></div>\n      <div class=\"dot\"></div>\n    </div>\n\n    <div *ngIf=\"!stilValidating\" class=\"ui message success\">\n      Succesfully validated your feed.\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/upload/upload.component.scss":
/*!**********************************************!*\
  !*** ./src/app/upload/upload.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".upload {\n  margin-left: 280px; }\n  .upload-container {\n    display: -webkit-flex;\n    display: flex;\n    -webkit-align-items: flex-end;\n            align-items: flex-end; }\n  .upload-container .input {\n      display: -webkit-inline-flex;\n      display: inline-flex;\n      -webkit-flex-direction: column;\n              flex-direction: column;\n      -webkit-flex: 1;\n              flex: 1;\n      margin-right: 16px; }\n  .upload .message {\n    margin-top: 8px; }\n  .upload .loading {\n    display: -webkit-flex;\n    display: flex;\n    -webkit-justify-content: center;\n            justify-content: center;\n    margin: 32px 0 12px; }\n  .upload .dot {\n    position: relative;\n    width: 8px;\n    height: 8px; }\n  .upload .dot:before {\n      content: \"\";\n      position: absolute;\n      display: block;\n      width: 8px;\n      height: 8px;\n      border-radius: 100%;\n      background-color: #2B90D9; }\n  .upload .dot:nth-child(1):before {\n      -webkit-animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955);\n              animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955); }\n  .upload .dot:nth-child(2):before {\n      -webkit-animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955);\n              animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955);\n      -webkit-animation-delay: .2s;\n              animation-delay: .2s; }\n  .upload .dot:nth-child(3):before {\n      -webkit-animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955);\n              animation: dotLoading 1.3s infinite cubic-bezier(0.455, 0.03, 0.515, 0.955);\n      -webkit-animation-delay: .4s;\n              animation-delay: .4s; }\n  .upload .pulse {\n    position: relative;\n    display: block;\n    width: 12px;\n    height: 12px;\n    border: none;\n    border-radius: 100%;\n    -webkit-transform: translate3d(0, 0, 0);\n            transform: translate3d(0, 0, 0); }\n  .upload .pulse.green {\n      box-shadow: 0 0 0 0 #f0f0f0, 0 0 0 0 rgba(7, 184, 147, 0.7);\n      background: #07B893;\n      -webkit-animation: pulseGreen 4s infinite cubic-bezier(0.66, 0.33, 0, 1);\n              animation: pulseGreen 4s infinite cubic-bezier(0.66, 0.33, 0, 1); }\n  .upload .pulse.red {\n      box-shadow: 0 0 0 0 #f0f0f0, 0 0 0 0 rgba(247, 27, 57, 0.7);\n      background: #F71B39;\n      -webkit-animation: pulseRed 1.25s infinite cubic-bezier(0.66, 0.33, 0, 1);\n              animation: pulseRed 1.25s infinite cubic-bezier(0.66, 0.33, 0, 1); }\n  @-webkit-keyframes pulseGreen {\n  0% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 0 rgba(7, 184, 147, 0.7); }\n  50% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 4px rgba(7, 184, 147, 0.3); }\n  100% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 0 rgba(7, 184, 147, 0.7); } }\n  @keyframes pulseGreen {\n  0% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 0 rgba(7, 184, 147, 0.7); }\n  50% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 4px rgba(7, 184, 147, 0.3); }\n  100% {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 0 rgba(7, 184, 147, 0.7); } }\n  @-webkit-keyframes pulseRed {\n  to {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 4px rgba(247, 27, 57, 0.3); } }\n  @keyframes pulseRed {\n  to {\n    box-shadow: 0 0 0 12px transparent, 0 0 0 4px rgba(247, 27, 57, 0.3); } }\n  @-webkit-keyframes dotLoading {\n  0% {\n    -webkit-transform: scale(0.2);\n            transform: scale(0.2);\n    opacity: .2; }\n  50% {\n    -webkit-transform: scale(1);\n            transform: scale(1);\n    opacity: 1; }\n  100% {\n    -webkit-transform: scale(0.2);\n            transform: scale(0.2);\n    opacity: .2; } }\n  @keyframes dotLoading {\n  0% {\n    -webkit-transform: scale(0.2);\n            transform: scale(0.2);\n    opacity: .2; }\n  50% {\n    -webkit-transform: scale(1);\n            transform: scale(1);\n    opacity: 1; }\n  100% {\n    -webkit-transform: scale(0.2);\n            transform: scale(0.2);\n    opacity: .2; } }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9ub3VkYWRyaWNoZW0vY29kZS9keW5hbWljLWZlZWQtdmFsaWRhdG9yL2Zyb250ZW5kL3NyYy9hcHAvdXBsb2FkL3VwbG9hZC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGtCQUFrQixFQUFBO0VBRWxCO0lBQ0UscUJBQWE7SUFBYixhQUFhO0lBQ2IsNkJBQXFCO1lBQXJCLHFCQUFxQixFQUFBO0VBRnRCO01BS0csNEJBQW9CO01BQXBCLG9CQUFvQjtNQUNwQiw4QkFBc0I7Y0FBdEIsc0JBQXNCO01BQ3RCLGVBQU87Y0FBUCxPQUFPO01BQ1Asa0JBQWtCLEVBQUE7RUFYeEI7SUFnQkksZUFBZSxFQUFBO0VBaEJuQjtJQXFCRSxxQkFBYTtJQUFiLGFBQWE7SUFDYiwrQkFBdUI7WUFBdkIsdUJBQXVCO0lBQ3ZCLG1CQUFtQixFQUFBO0VBdkJyQjtJQTJCSSxrQkFBa0I7SUFDbEIsVUFBVTtJQUNWLFdBQVcsRUFBQTtFQTdCZjtNQWdDTSxXQUFXO01BQ1gsa0JBQWtCO01BQ2xCLGNBQWM7TUFDZCxVQUFVO01BQ1YsV0FBVztNQUNYLG1CQUFtQjtNQUNuQix5QkFBeUIsRUFBQTtFQXRDL0I7TUF5Q00sbUZBQXVFO2NBQXZFLDJFQUF1RSxFQUFBO0VBekM3RTtNQTRDTSxtRkFBdUU7Y0FBdkUsMkVBQXVFO01BQ3ZFLDRCQUFvQjtjQUFwQixvQkFBb0IsRUFBQTtFQTdDMUI7TUFnRE0sbUZBQXVFO2NBQXZFLDJFQUF1RTtNQUN2RSw0QkFBb0I7Y0FBcEIsb0JBQW9CLEVBQUE7RUFqRDFCO0lBc0RJLGtCQUFrQjtJQUNsQixjQUFjO0lBQ2QsV0FBVztJQUNYLFlBQVk7SUFDWixZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLHVDQUErQjtZQUEvQiwrQkFBK0IsRUFBQTtFQTVEbkM7TUFnRU0sMkRBQWlEO01BQ2pELG1CQUFtQjtNQUNuQix3RUFBZ0U7Y0FBaEUsZ0VBQWdFLEVBQUE7RUFsRXRFO01Bc0VNLDJEQUFpRDtNQUNqRCxtQkFBbUI7TUFDbkIseUVBQWlFO2NBQWpFLGlFQUFpRSxFQUFBO0VBS3ZFO0VBQ0U7SUFDRSxrRUFBd0QsRUFBQTtFQUUxRDtJQUNFLG9FQUEwRCxFQUFBO0VBRTVEO0lBQ0Usa0VBQXdELEVBQUEsRUFBQTtFQVI1RDtFQUNFO0lBQ0Usa0VBQXdELEVBQUE7RUFFMUQ7SUFDRSxvRUFBMEQsRUFBQTtFQUU1RDtJQUNFLGtFQUF3RCxFQUFBLEVBQUE7RUFHNUQ7RUFDRTtJQUNFLG9FQUEwRCxFQUFBLEVBQUE7RUFGOUQ7RUFDRTtJQUNFLG9FQUEwRCxFQUFBLEVBQUE7RUFJOUQ7RUFDQztJQUNDLDZCQUFvQjtZQUFwQixxQkFBb0I7SUFDcEIsV0FBVyxFQUFBO0VBRVo7SUFDQywyQkFBbUI7WUFBbkIsbUJBQW1CO0lBQ25CLFVBQVUsRUFBQTtFQUVYO0lBQ0MsNkJBQW9CO1lBQXBCLHFCQUFvQjtJQUNwQixXQUFXLEVBQUEsRUFBQTtFQVhiO0VBQ0M7SUFDQyw2QkFBb0I7WUFBcEIscUJBQW9CO0lBQ3BCLFdBQVcsRUFBQTtFQUVaO0lBQ0MsMkJBQW1CO1lBQW5CLG1CQUFtQjtJQUNuQixVQUFVLEVBQUE7RUFFWDtJQUNDLDZCQUFvQjtZQUFwQixxQkFBb0I7SUFDcEIsV0FBVyxFQUFBLEVBQUEiLCJmaWxlIjoic3JjL2FwcC91cGxvYWQvdXBsb2FkLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLnVwbG9hZCB7XG4gIG1hcmdpbi1sZWZ0OiAyODBweDtcblxuICAmLWNvbnRhaW5lciB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogZmxleC1lbmQ7XG5cbiAgICAuaW5wdXQge1xuICAgICAgZGlzcGxheTogaW5saW5lLWZsZXg7XG4gICAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgICAgZmxleDogMTtcbiAgICAgIG1hcmdpbi1yaWdodDogMTZweDtcbiAgICB9XG4gIH1cblxuICAubWVzc2FnZSB7IFxuICAgIG1hcmdpbi10b3A6IDhweDtcbiAgfVxuXG5cbi5sb2FkaW5nIHtcbiAgZGlzcGxheTogZmxleDtcbiAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gIG1hcmdpbjogMzJweCAwIDEycHg7XG59XG5cbiAgLmRvdCB7XG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xuICAgIHdpZHRoOiA4cHg7XG4gICAgaGVpZ2h0OiA4cHg7XG5cbiAgICAmOmJlZm9yZSB7XG4gICAgICBjb250ZW50OiBcIlwiO1xuICAgICAgcG9zaXRpb246IGFic29sdXRlO1xuICAgICAgZGlzcGxheTogYmxvY2s7XG4gICAgICB3aWR0aDogOHB4O1xuICAgICAgaGVpZ2h0OiA4cHg7XG4gICAgICBib3JkZXItcmFkaXVzOiAxMDAlO1xuICAgICAgYmFja2dyb3VuZC1jb2xvcjogIzJCOTBEOTtcbiAgICB9XG4gICAgJjpudGgtY2hpbGQoMSk6YmVmb3JlIHtcbiAgICAgIGFuaW1hdGlvbjogZG90TG9hZGluZyAxLjNzIGluZmluaXRlIGN1YmljLWJlemllciguNDU1LCAuMDMsIC41MTUsIC45NTUpO1xuICAgIH1cbiAgICAmOm50aC1jaGlsZCgyKTpiZWZvcmUge1xuICAgICAgYW5pbWF0aW9uOiBkb3RMb2FkaW5nIDEuM3MgaW5maW5pdGUgY3ViaWMtYmV6aWVyKC40NTUsIC4wMywgLjUxNSwgLjk1NSk7XG4gICAgICBhbmltYXRpb24tZGVsYXk6IC4ycztcbiAgICB9XG4gICAgJjpudGgtY2hpbGQoMyk6YmVmb3JlIHtcbiAgICAgIGFuaW1hdGlvbjogZG90TG9hZGluZyAxLjNzIGluZmluaXRlIGN1YmljLWJlemllciguNDU1LCAuMDMsIC41MTUsIC45NTUpO1xuICAgICAgYW5pbWF0aW9uLWRlbGF5OiAuNHM7XG4gICAgfVxuICB9XG5cbiAgLnB1bHNlIHtcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gICAgZGlzcGxheTogYmxvY2s7XG4gICAgd2lkdGg6IDEycHg7XG4gICAgaGVpZ2h0OiAxMnB4O1xuICAgIGJvcmRlcjogbm9uZTtcbiAgICBib3JkZXItcmFkaXVzOiAxMDAlO1xuICAgIHRyYW5zZm9ybTogdHJhbnNsYXRlM2QoMCwgMCwgMCk7XG4gICAgXG5cbiAgICAmLmdyZWVuIHtcbiAgICAgIGJveC1zaGFkb3c6IDAgMCAwIDAgI2YwZjBmMCwgMCAwIDAgMCByZ2JhKCMwN0I4OTMsIDAuNyk7XG4gICAgICBiYWNrZ3JvdW5kOiAjMDdCODkzO1xuICAgICAgYW5pbWF0aW9uOiBwdWxzZUdyZWVuIDRzIGluZmluaXRlIGN1YmljLWJlemllcigwLjY2LCAwLjMzLCAwLCAxKTtcbiAgICB9XG4gICAgXG4gICAgJi5yZWQge1xuICAgICAgYm94LXNoYWRvdzogMCAwIDAgMCAjZjBmMGYwLCAwIDAgMCAwIHJnYmEoI0Y3MUIzOSwgMC43KTtcbiAgICAgIGJhY2tncm91bmQ6ICNGNzFCMzk7XG4gICAgICBhbmltYXRpb246IHB1bHNlUmVkIDEuMjVzIGluZmluaXRlIGN1YmljLWJlemllcigwLjY2LCAwLjMzLCAwLCAxKTtcbiAgICB9XG4gIH1cbn1cblxuQGtleWZyYW1lcyBwdWxzZUdyZWVuIHtcbiAgMCUge1xuICAgIGJveC1zaGFkb3c6IDAgMCAwIDEycHggdHJhbnNwYXJlbnQsIDAgMCAwIDAgcmdiYSgjMDdCODkzLCAuNyk7XG4gIH1cbiAgNTAlIHtcbiAgICBib3gtc2hhZG93OiAwIDAgMCAxMnB4IHRyYW5zcGFyZW50LCAwIDAgMCA0cHggcmdiYSgjMDdCODkzLCAuMyk7XG4gIH1cbiAgMTAwJSB7XG4gICAgYm94LXNoYWRvdzogMCAwIDAgMTJweCB0cmFuc3BhcmVudCwgMCAwIDAgMCByZ2JhKCMwN0I4OTMsIC43KTtcbiAgfVxufVxuQGtleWZyYW1lcyBwdWxzZVJlZCB7XG4gIHRvIHtcbiAgICBib3gtc2hhZG93OiAwIDAgMCAxMnB4IHRyYW5zcGFyZW50LCAwIDAgMCA0cHggcmdiYSgjRjcxQjM5LCAuMyk7XG4gIH1cbn1cblxuQGtleWZyYW1lcyBkb3RMb2FkaW5nIHtcblx0MCUge1xuXHRcdHRyYW5zZm9ybTogc2NhbGUoLjIpO1xuXHRcdG9wYWNpdHk6IC4yO1xuXHR9XG5cdDUwJSB7XG5cdFx0dHJhbnNmb3JtOiBzY2FsZSgxKTtcblx0XHRvcGFjaXR5OiAxO1xuXHR9XG5cdDEwMCUge1xuXHRcdHRyYW5zZm9ybTogc2NhbGUoLjIpO1xuXHRcdG9wYWNpdHk6IC4yO1xuXHR9XG59Il19 */"

/***/ }),

/***/ "./src/app/upload/upload.component.ts":
/*!********************************************!*\
  !*** ./src/app/upload/upload.component.ts ***!
  \********************************************/
/*! exports provided: UploadComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadComponent", function() { return UploadComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_feed_http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/feed-http.service */ "./src/app/services/feed-http.service.ts");
/* harmony import */ var _services_feed_model_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/feed-model.service */ "./src/app/services/feed-model.service.ts");




var UploadComponent = /** @class */ (function () {
    function UploadComponent(feedHttpService, feedModelService) {
        this.feedHttpService = feedHttpService;
        this.feedModelService = feedModelService;
        this.inputUrl = 'https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml';
        this.isUploadSuccess = false;
        this.submitted = false;
        this.echoText = '';
        this.connected = false;
        this.stilValidating = true;
        this.errors = [];
        this.warnings = [];
    }
    UploadComponent.prototype.ngOnInit = function () {
        this.connecSocket();
    };
    UploadComponent.prototype.resetUI = function () {
        this.errors = [];
        this.warnings = [];
        this.stilValidating = true;
    };
    UploadComponent.prototype.startValidation = function () {
        var _this = this;
        this.resetUI();
        var body = {
            url: this.inputUrl,
            validationId: 'id',
            socketSessionId: window.sessionStorage.getItem('sessionId')
        };
        this.feedHttpService.uploadFeedUrl(body)
            .subscribe(function (data) {
            _this.isUploadSuccess = data['success'];
            _this.submitted = true;
            setTimeout(function () {
                _this.submitted = false;
            }, 3200);
        });
    };
    UploadComponent.prototype.connecSocket = function () {
        var _this = this;
        console.log('trying to connect');
        this.socket = new WebSocket('wss://' + window.location.host + '/socket');
        this.socket.onopen = function () { return _this.webSocketOpen(); };
        this.socket.onclose = function () { return _this.webSocketClose(); };
        this.socket.onmessage = function (message) { return _this.webSocketGetMessage(message); };
        this.socket.onerror = function (message) { return _this.webSocketError(message); };
    };
    UploadComponent.prototype.webSocketOpen = function () {
        console.log('connected');
        this.connected = true;
    };
    UploadComponent.prototype.wsSendMessage = function () {
        this.socket.send('is client connected?');
    };
    UploadComponent.prototype.webSocketCloseConnection = function () {
        this.socket.close();
        this.connected = false;
    };
    UploadComponent.prototype.webSocketClose = function () {
        console.log('Disconnected');
        this.connected = false;
    };
    UploadComponent.prototype.webSocketGetMessage = function (message) {
        message = JSON.parse(message.data);
        console.log(message);
        switch (message.type) {
            case ('init'):
                this.activeSocketSessionId = message.id;
                window.sessionStorage.setItem('sessionId', message.id);
                break;
            case 'finale':
                this.stilValidating = false;
                // TODO: feedModelService push feed from finale message from socket.
                this.feedModelService.trigger();
                break;
            case 'error':
                this.errors.push(message);
                break;
            case 'warning':
                this.warnings.push(message);
        }
    };
    UploadComponent.prototype.webSocketError = function (message) {
        console.log('socket error...', { message: message });
    };
    UploadComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-upload',
            template: __webpack_require__(/*! ./upload.component.html */ "./src/app/upload/upload.component.html"),
            styles: [__webpack_require__(/*! ./upload.component.scss */ "./src/app/upload/upload.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_feed_http_service__WEBPACK_IMPORTED_MODULE_2__["FeedHttpService"],
            _services_feed_model_service__WEBPACK_IMPORTED_MODULE_3__["FeedModelService"]])
    ], UploadComponent);
    return UploadComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false,
    API_URL: 'http://localhost:9090/api'
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/noudadrichem/code/dynamic-feed-validator/frontend/src/main.ts */"./src/main.ts");


/***/ }),

/***/ 1:
/*!********************!*\
  !*** ws (ignored) ***!
  \********************/
/*! no static exports found */
/***/ (function(module, exports) {

/* (ignored) */

/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map