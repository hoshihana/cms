(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a4f596ec"],{"159b":function(e,t,r){var a=r("da84"),o=r("fdbc"),n=r("17c2"),i=r("9112");for(var s in o){var l=a[s],c=l&&l.prototype;if(c&&c.forEach!==n)try{i(c,"forEach",n)}catch(d){c.forEach=n}}},"15ce":function(e,t,r){"use strict";r("bb07")},"17c2":function(e,t,r){"use strict";var a=r("b727").forEach,o=r("a640"),n=r("ae40"),i=o("forEach"),s=n("forEach");e.exports=i&&s?[].forEach:function(e){return a(this,e,arguments.length>1?arguments[1]:void 0)}},"1dde":function(e,t,r){var a=r("d039"),o=r("b622"),n=r("2d00"),i=o("species");e.exports=function(e){return n>=51||!a((function(){var t=[],r=t.constructor={};return r[i]=function(){return{foo:1}},1!==t[e](Boolean).foo}))}},4160:function(e,t,r){"use strict";var a=r("23e7"),o=r("17c2");a({target:"Array",proto:!0,forced:[].forEach!=o},{forEach:o})},4797:function(e,t,r){},"59ca":function(e,t,r){"use strict";var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("Form",{staticStyle:{"margin-top":"5%"},attrs:{model:e.formItem,"label-colon":"","label-width":80}},[r("FormItem",{attrs:{"show-message":"",label:"收件人"}},[r("Input",{attrs:{type:"text"},model:{value:e.formItem.senderAccount,callback:function(t){e.$set(e.formItem,"senderAccount",t)},expression:"formItem.senderAccount"}})],1),r("FormItem",{attrs:{"show-message":"",label:"内容"}},[r("Input",{attrs:{rows:4,type:"textarea"},model:{value:e.formItem.content,callback:function(t){e.$set(e.formItem,"content",t)},expression:"formItem.content"}})],1),r("FormItem",{attrs:{"show-message":""}},[r("Button",{attrs:{type:"primary"},on:{click:e.clickForCheck}},[e._v("确认")]),r("Button",{staticStyle:{"margin-left":"15%"},on:{click:e.closeFatherModal}},[e._v("取消")])],1)],1),r("Modal",{staticStyle:{padding:"20px"},attrs:{"footer-hide":""},model:{value:e.openModal,callback:function(t){e.openModal=t},expression:"openModal"}},[r("Form",{staticStyle:{"margin-top":"5%"},attrs:{model:e.formItem,"label-colon":"","label-width":120}},[r("FormItem",{attrs:{"show-message":"",label:"收件人账号"}},[r("Input",{attrs:{type:"text"},model:{value:e.formItem.senderAccount,callback:function(t){e.$set(e.formItem,"senderAccount",t)},expression:"formItem.senderAccount"}})],1),r("FormItem",{attrs:{"show-message":""}},[r("Button",{attrs:{type:"primary"},on:{click:e.sendMessage}},[e._v("确认")]),r("Button",{staticStyle:{"margin-left":"15%"},on:{click:function(t){e.openModal=!1}}},[e._v("取消")])],1)],1)],1)],1)},o=[],n={name:"WriteMail",props:["sendId"],data:function(){return{formItem:{senderAccount:"",content:""},openModal:!1}},methods:{autoFillAccount:function(){var e=this,t={accountId:e.sendId.account};this.$axios({method:"post",url:"".concat(e.$baseURI,"/api/message/getAccount"),data:t}).then((function(t){e.formItem.senderAccount=t["data"]["username"]}))},clickForCheck:function(){this.openModal=!0},sendMessage:function(){var e=this,t={username:e.formItem.senderAccount,content:e.formItem.content};e.$axios({method:"post",url:"".concat(e.$baseURI,"/api/message/sendByUsername"),data:t}).then((function(t){!0===t["data"]["success"]?(e.$Message.success("发送成功"),e.openModal=!1,e.$emit("closeSendModal",!1)):e.$Message.error(t["data"]["message"])}))},closeFatherModal:function(){this.$emit("closeSendModal",!1)}}},i=n,s=r("0c7c"),l=Object(s["a"])(i,a,o,!1,null,"20d29675",null);t["a"]=l.exports},"5b79":function(e,t,r){"use strict";r("4797")},"65f0":function(e,t,r){var a=r("861d"),o=r("e8b5"),n=r("b622"),i=n("species");e.exports=function(e,t){var r;return o(e)&&(r=e.constructor,"function"!=typeof r||r!==Array&&!o(r.prototype)?a(r)&&(r=r[i],null===r&&(r=void 0)):r=void 0),new(void 0===r?Array:r)(0===t?0:t)}},8418:function(e,t,r){"use strict";var a=r("c04e"),o=r("9bf2"),n=r("5c6c");e.exports=function(e,t,r){var i=a(t);i in e?o.f(e,i,n(0,r)):e[i]=r}},a640:function(e,t,r){"use strict";var a=r("d039");e.exports=function(e,t){var r=[][e];return!!r&&a((function(){r.call(null,t||function(){throw 1},1)}))}},ae40:function(e,t,r){var a=r("83ab"),o=r("d039"),n=r("5135"),i=Object.defineProperty,s={},l=function(e){throw e};e.exports=function(e,t){if(n(s,e))return s[e];t||(t={});var r=[][e],c=!!n(t,"ACCESSORS")&&t.ACCESSORS,d=n(t,0)?t[0]:l,u=n(t,1)?t[1]:void 0;return s[e]=!!r&&!o((function(){if(c&&!a)return!0;var e={length:-1};c?i(e,1,{enumerable:!0,get:l}):e[1]=1,r.call(e,d,u)}))}},b0c0:function(e,t,r){var a=r("83ab"),o=r("9bf2").f,n=Function.prototype,i=n.toString,s=/^\s*function ([^ (]*)/,l="name";a&&!(l in n)&&o(n,l,{configurable:!0,get:function(){try{return i.call(this).match(s)[1]}catch(e){return""}}})},b727:function(e,t,r){var a=r("0366"),o=r("44ad"),n=r("7b0b"),i=r("50c4"),s=r("65f0"),l=[].push,c=function(e){var t=1==e,r=2==e,c=3==e,d=4==e,u=6==e,m=5==e||u;return function(f,p,h,g){for(var v,I,b=n(f),y=o(b),w=a(p,h,3),M=i(y.length),k=0,x=g||s,F=t?x(f,M):r?x(f,0):void 0;M>k;k++)if((m||k in y)&&(v=y[k],I=w(v,k,b),e))if(t)F[k]=I;else if(I)switch(e){case 3:return!0;case 5:return v;case 6:return k;case 2:l.call(F,v)}else if(d)return!1;return u?-1:c||d?d:F}};e.exports={forEach:c(0),map:c(1),filter:c(2),some:c(3),every:c(4),find:c(5),findIndex:c(6)}},bb07:function(e,t,r){},c975:function(e,t,r){"use strict";var a=r("23e7"),o=r("4d64").indexOf,n=r("a640"),i=r("ae40"),s=[].indexOf,l=!!s&&1/[1].indexOf(1,-0)<0,c=n("indexOf"),d=i("indexOf",{ACCESSORS:!0,1:0});a({target:"Array",proto:!0,forced:l||!c||!d},{indexOf:function(e){return l?s.apply(this,arguments)||0:o(this,e,arguments.length>1?arguments[1]:void 0)}})},d8b7:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("div",[r("Button",{attrs:{type:"primary"},on:{click:function(t){e.registerModal=!0}}},[e._v("添加车队")]),r("Input",{staticStyle:{width:"auto","margin-left":"15px"},attrs:{suffix:"ios-search",placeholder:"查找车队"},model:{value:e.keyword,callback:function(t){e.keyword=t},expression:"keyword"}})],1),r("Table",{staticStyle:{margin:"30px auto"},attrs:{columns:this.columns,data:this.currentFleetData,stripe:!0}}),r("Page",{staticStyle:{"text-align":"center"},attrs:{total:e.allFleetData.length,"show-sizer":"","show-elevator":""},on:{"on-page-size-change":e.changePrePageNum,"on-change":e.showPage}}),r("Modal",{staticStyle:{padding:"20px"},attrs:{"footer-hide":"","mask-closable":!1},model:{value:e.registerModal,callback:function(t){e.registerModal=t},expression:"registerModal"}},[r("FleetRegister",{on:{setRegisterModal:e.setRegisterModal}})],1),r("Modal",{staticStyle:{padding:"20px"},attrs:{width:"80","footer-hide":"","mask-closable":!1},model:{value:e.driverDetailModal,callback:function(t){e.driverDetailModal=t},expression:"driverDetailModal"}},[r("DriverDetail",{ref:"driverDetail",attrs:{fleetInfo:e.showingFleetInfo},on:{setdriverDetailModal:e.setDriverDetailModal,reloadData:e.reloadData}})],1)],1)},o=[],n=(r("4160"),r("c975"),r("fb6a"),r("b0c0"),r("159b"),function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticStyle:{padding:"0"}},[r("h2",{staticClass:"center",staticStyle:{"margin-bottom":"5%"}},[e._v("添加车队")]),r("Form",{ref:"formItem",attrs:{"hide-required-mark":"",model:e.formItem,rules:e.fromValidate,"label-width":80}},[r("FormItem",{attrs:{label:"车队名",prop:"name"}},[r("Input",{model:{value:e.formItem.name,callback:function(t){e.$set(e.formItem,"name",t)},expression:"formItem.name"}})],1),r("FormItem",{attrs:{label:"联系电话",prop:"phone"}},[r("Input",{model:{value:e.formItem.phone,callback:function(t){e.$set(e.formItem,"phone",t)},expression:"formItem.phone"}})],1),r("FormItem",{attrs:{label:"详情",prop:"detail"}},[r("Input",{staticClass:"input_size",attrs:{type:"textarea"},model:{value:e.formItem.detail,callback:function(t){e.$set(e.formItem,"detail",t)},expression:"formItem.detail"}})],1),r("div",{staticClass:"center"},[r("Button",{staticStyle:{"margin-right":"10px"},on:{click:function(t){return e.resetForm("formItem")}}},[e._v("重置")]),r("Button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("formItem")}}},[e._v("提交")])],1)],1)],1)}),i=[],s={name:"FleetRegister",data:function(){return{formItem:{name:"",phone:"",detail:""},fromValidate:{name:[{required:!0,message:"车队名不能为空",trigger:"blur"}],phone:[{required:!0,message:"联系电话不能为空",trigger:"blur"}],detail:[{required:!0,message:"详情不能为空",trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this,r=this;this.$refs[e].validate((function(a){if(a){var o={name:t.formItem.name,detail:t.formItem.detail,telephone:t.formItem.phone};t.$axios({method:"post",url:"".concat(t.$baseURI,"/api/admin/fleet/add"),data:o}).then((function(t){!0===t["data"]["success"]?(r.$Message.success("注册成功"),setTimeout((function(){r.$emit("setRegisterModal",!1),r.resetForm(e)}),300)):r.$Message.error(t["data"]["message"])}))}}))},resetForm:function(e){this.$refs[e].resetFields()}}},l=s,c=(r("15ce"),r("0c7c")),d=Object(c["a"])(l,n,i,!1,null,"1165fa46",null),u=d.exports,m=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("div",[r("Button",{attrs:{type:"primary"},on:{click:e.showRegisterModal}},[e._v("添加司机账号")]),r("Input",{staticStyle:{width:"auto","margin-left":"15px"},attrs:{suffix:"ios-search",placeholder:"查找司机账号"},model:{value:e.keyword,callback:function(t){e.keyword=t},expression:"keyword"}})],1),r("Table",{staticStyle:{margin:"30px auto","overflow-y":"auto"},attrs:{columns:this.columns,data:this.fleetInfo.driverData,stripe:!0}}),r("Modal",{staticStyle:{padding:"20px"},attrs:{"footer-hide":"","mask-closable":!1},model:{value:e.registerModal,callback:function(t){e.registerModal=t},expression:"registerModal"}},[r("DriverRegister",{attrs:{registerInfo:e.registerInfo},on:{setRegisterModal:e.setRegisterModal}})],1),r("Modal",{attrs:{"footer-hide":"","mask-closable":!1},model:{value:e.changePasswordModal,callback:function(t){e.changePasswordModal=t},expression:"changePasswordModal"}},[r("ChangeDriverPassword",{attrs:{"driver-id":this.changePasswordAccount.account},on:{closeChangeModal:e.closeChangeModal}})],1),r("Modal",{staticStyle:{padding:"20px"},attrs:{"footer-hide":""},model:{value:e.openWriteMail,callback:function(t){e.openWriteMail=t},expression:"openWriteMail"}},[r("div",{staticStyle:{padding:"5%"}},[r("WriteMail",{ref:"fillAccount",attrs:{"send-id":this.sendMailAccount},on:{closeSendModal:e.closeSendModal}})],1)])],1)},f=[],p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticStyle:{padding:"0"}},[r("h2",{staticClass:"center",staticStyle:{"margin-bottom":"5%"}},[e._v("添加司机")]),r("Form",{ref:"formItem",attrs:{"hide-required-mark":"",model:e.formItem,rules:e.fromValidate,"label-width":80}},[r("FormItem",{attrs:{label:"用户名",prop:"username"}},[r("Input",{attrs:{placeholder:"长度为2-16的字符"},model:{value:e.formItem.username,callback:function(t){e.$set(e.formItem,"username",t)},expression:"formItem.username"}})],1),r("FormItem",{attrs:{label:"密码",prop:"password"}},[r("Input",{attrs:{password:"",type:"password",placeholder:"长度为8-32, 需包含字母和数字"},model:{value:e.formItem.password,callback:function(t){e.$set(e.formItem,"password",t)},expression:"formItem.password"}})],1),r("FormItem",{attrs:{label:"姓名",prop:"name"}},[r("Input",{staticStyle:{width:"100px"},model:{value:e.formItem.name,callback:function(t){e.$set(e.formItem,"name",t)},expression:"formItem.name"}})],1),r("FormItem",{attrs:{label:"性别",prop:"gender"}},[r("RadioGroup",{model:{value:e.formItem.gender,callback:function(t){e.$set(e.formItem,"gender",t)},expression:"formItem.gender"}},[r("Radio",{attrs:{label:"MALE"}},[e._v("男")]),r("Radio",{attrs:{label:"FEMALE"}},[e._v("女")])],1)],1),r("FormItem",{attrs:{label:"身份证号",prop:"residentIdNumber"}},[r("Input",{model:{value:e.formItem.residentIdNumber,callback:function(t){e.$set(e.formItem,"residentIdNumber",t)},expression:"formItem.residentIdNumber"}})],1),r("FormItem",{attrs:{label:"电话",prop:"telephone"}},[r("Input",{staticStyle:{width:"200px"},model:{value:e.formItem.telephone,callback:function(t){e.$set(e.formItem,"telephone",t)},expression:"formItem.telephone"}})],1),r("div",{staticClass:"center"},[r("Button",{staticStyle:{"margin-right":"10px"},on:{click:function(t){return e.resetForm("formItem")}}},[e._v("重置")]),r("Button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("formItem")}}},[e._v("提交")])],1)],1)],1)},h=[],g={name:"DriverRegister",data:function(){return{formItem:{username:"",password:"",name:"",gender:"",residentIdNumber:"",telephone:""},fromValidate:{username:[{required:!0,message:"用户名不能为空",trigger:"blur"}],password:[{required:!0,message:"密码不能为空",trigger:"blur"},{type:"string",min:8,message:"密码至少需8位",trigger:"blur"},{type:"string",max:32,message:"密码最多32位",trigger:"blur"},{pattern:/(?=.*[0-9])(?=.*[a-zA-Z])/,message:"密码需包含字母和数字",trigger:"blur"}],name:[{required:!0,message:"酒店名不能为空",trigger:"blur"}],gender:[{required:!0,message:"性别不能为空",trigger:"blur"}],residentIdNumber:[{required:!0,message:"身份证号不能为空",trigger:"blur"},{pattern:/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,message:"身份证号不合法",trigger:"blur"}],telephone:[{required:!0,message:"手机号码不能为空",trigger:"blur"},{pattern:/^[1][0-9]{10}$/,message:"手机号不合法",trigger:"blur"}]}}},props:["registerInfo"],methods:{submitForm:function(e){var t=this,r=this;this.$refs[e].validate((function(a){if(a){var o={username:t.formItem.username,password:t.formItem.password,fleetId:t.registerInfo.fleetId,name:t.formItem.name,gender:t.formItem.gender,residentIdNumber:t.formItem.residentIdNumber,telephone:t.formItem.telephone};t.$axios({method:"post",url:"".concat(t.$baseURI,"/api/admin/driver/add"),data:o}).then((function(t){!0===t["data"]["success"]?(r.$Message.success("注册成功"),setTimeout((function(){r.$emit("setRegisterModal",!1),r.resetForm(e)}),300)):r.$Message.error(t["data"]["message"])}))}}))},resetForm:function(e){this.$refs[e].resetFields()}}},v=g,I=(r("5b79"),Object(c["a"])(v,p,h,!1,null,"2bef69b0",null)),b=I.exports,y=r("59ca"),w=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("Form",{ref:"formItem",staticStyle:{"margin-top":"5%"},attrs:{"hide-required-mark":"",rules:e.fromValidate,model:e.formItem}},[r("h2",{staticStyle:{"text-align":"center"}},[e._v("修改密码")]),r("FormItem",{attrs:{label:"新密码",prop:"password"}},[r("Input",{attrs:{type:"password",password:"",placeholder:"长度为8-32, 需包含字母和数字"},model:{value:e.formItem.password,callback:function(t){e.$set(e.formItem,"password",t)},expression:"formItem.password"}})],1),r("FormItem",{attrs:{label:"确认密码",prop:"passwordCheck"}},[r("Input",{attrs:{type:"password",password:"",placeholder:"重复上述的密码"},model:{value:e.formItem.passwordCheck,callback:function(t){e.$set(e.formItem,"passwordCheck",t)},expression:"formItem.passwordCheck"}})],1),r("FormItem",[r("Button",{staticStyle:{float:"right","margin-left":"16px"},attrs:{type:"primary"},on:{click:function(t){return e.submitForm("formItem")}}},[e._v("修改 ")]),r("Button",{staticStyle:{float:"right"},attrs:{type:"text"},on:{click:function(){e.resetForm("formItem"),e.cancelButton()}}},[e._v("取消 ")])],1)],1)],1)},M=[],k={name:"ChangePassword",data:function(){var e=this,t=function(t,r,a){return r!==e.formItem.password?a(new Error("密码验证不一致")):a()};return{formItem:{password:"",passwordCheck:""},fromValidate:{password:[{required:!0,message:"密码不能为空",trigger:"blur"},{type:"string",min:8,message:"密码至少需8位",trigger:"blur"},{type:"string",max:32,message:"密码最多32位",trigger:"blur"},{pattern:/(?=.*[0-9])(?=.*[a-zA-Z])/,message:"密码需包含字母和数字",trigger:"blur"}],passwordCheck:[{required:!0,message:"确认密码不能为空",trigger:"blur"},{validator:t,trigger:"blur"}]}}},props:["driverId"],methods:{resetForm:function(e){this.$refs[e].resetFields()},cancelButton:function(){this.$emit("gotoProfile",!1)},submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(e){var r={driverId:t.driverId,password:t.formItem.password};t.$axios({method:"post",url:"".concat(t.$baseURI,"/api/admin/driver/password/modify"),data:r}).then((function(e){!0===e["data"]["success"]?(t.$Message.success("修改成功"),t.$emit("closeChangeModal",!1)):t.$Message.error(e["data"]["message"])}))}}))}}},x=k,F=Object(c["a"])(x,w,M,!1,null,"f7005d08",null),D=F.exports,S={name:"DriverDetail",components:{WriteMail:y["a"],DriverRegister:b,ChangeDriverPassword:D},data:function(){var e=this;return{columns:[{title:"司机编号",key:"driverId",align:"center"},{title:"姓名",key:"name",align:"center"},{title:"用户名",key:"username",align:"center"},{title:"电话号码",key:"telephone",align:"center",width:"125"},{title:"操作",key:"operation",align:"center",width:"180",render:function(t,r){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.changePassword(r.row.driverId)}}},"修改密码"),t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.sendMail(r.row.accountId)}}},"发信息")])}}],searching:!1,keyword:"",driverDataBackup:[],registerModal:!1,registerInfo:{fleetId:0},loaded:!0,openWriteMail:!1,sendMailAccount:{account:""},changePasswordAccount:{account:""},changePasswordModal:!1}},props:["fleetInfo"],methods:{showRegisterModal:function(){this.registerInfo.fleetId=this.fleetInfo.fleetId,this.registerModal=!0},setRegisterModal:function(e){this.registerModal=e;var t=this;setTimeout((function(){t.$emit("reloadData")}),300)},sendMail:function(e){this.sendMailAccount.account=e,console.log(this.sendMailAccount.account),this.$refs.fillAccount.autoFillAccount(),this.openWriteMail=!0},closeSendModal:function(e){this.openWriteMail=e},changePassword:function(e){this.changePasswordModal=!0,this.changePasswordAccount.account=e,console.log(this.changePasswordAccount.account)},closeChangeModal:function(e){this.changePasswordModal=e}},watch:{keyword:function(){var e=this,t=this;if(this.timer&&clearTimeout(this.timer),""===this.keyword)return t.fleetInfo.driverData=t.driverDataBackup.slice(0),void(t.searching=!1);this.timer=setTimeout((function(){t.searching||(t.driverDataBackup=t.fleetInfo.driverData.slice(0)),t.searching=!0,t.fleetInfo.driverData=[],t.driverDataBackup.forEach((function(r){(r.name+r.driverId+r.accountId+r.username).indexOf(e.keyword)>-1&&t.fleetInfo.driverData.push(r)}))}),100)}}},$=S,A=Object(c["a"])($,m,f,!1,null,"67ea5078",null),R=A.exports,P={name:"Driver",components:{DriverDetail:R,FleetRegister:u},data:function(){var e=this;return{columns:[{title:"车队编号",key:"fleetId",align:"center"},{title:"车队名",key:"name",align:"center"},{title:"司机数量",key:"driverAmount",align:"center"},{title:"联系方式",key:"telephone",align:"center",width:125},{title:"操作",key:"operation",align:"center",width:150,render:function(t,r){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.showDriverInfo(r.row.fleetId)}}},"司机管理")])}}],currentPage:0,prePageNum:10,driverData:{},showingFleetInfo:{driverData:[],fleetId:0},currentFleetData:[],allFleetData:[],allFleetDataBackup:[],keyword:"",searching:!1,registerModal:!1,driverDetailModal:!1}},created:function(){this.loadFleetData()},methods:{reloadData:function(){this.loadFleetData(),this.driverDetailModal=!1},loadFleetData:function(){var e=this;this.$axios({method:"post",url:"".concat(this.$baseURI,"/api/admin/fleet/getAll")}).then((function(t){e.allFleetData=[],t["data"].forEach((function(t){var r={fleetId:t["id"],name:t["name"],driverAmount:t["driverAmount"],telephone:t["telephone"]};e.allFleetData.push(r),e.$axios({method:"post",url:"".concat(e.$baseURI,"/api/admin/driver/getAll"),data:{fleetId:t["id"]}}).then((function(r){var a=t["id"];e.driverData[a]=[],r["data"].forEach((function(t){var r={accountId:t["accountId"],username:t["username"],driverId:t["driverId"],name:t["name"],telephone:t["telephone"]};e.driverData[a].push(r)}))}))})),e.currentFleetData=e.allFleetData.slice(0,10)}))},showDriverInfo:function(e){this.showingFleetInfo.fleetId=e,this.showingFleetInfo.driverData=this.driverData[e].slice(0),this.driverDetailModal=!0},changePrePageNum:function(e){this.prePageNum=e,this.currentFleetData=this.allFleetData.slice(0,e+1)},showPage:function(e){this.currentFleetData=this.allFleetData.slice(this.prePageNum*(e-1),this.prePageNum*e+1)},setRegisterModal:function(e){this.registerModal=e},setDriverDetailModal:function(e){this.driverDetailModal=e}},watch:{keyword:function(){var e=this,t=this;if(this.timer&&clearTimeout(this.timer),""===this.keyword)return t.allFleetData=t.allFleetDataBackup.slice(0),t.showPage(1),void(t.searching=!1);this.timer=setTimeout((function(){t.searching||(t.allFleetDataBackup=t.allFleetData.slice(0)),t.searching=!0,t.allFleetData=[],t.allFleetDataBackup.forEach((function(r){(r.name+r.fleetId+r.driverAmount).indexOf(e.keyword)>-1&&t.allFleetData.push(r)})),t.showPage(1)}),100)}}},C=P,E=Object(c["a"])(C,a,o,!1,null,"37a94063",null);t["default"]=E.exports},e8b5:function(e,t,r){var a=r("c6b6");e.exports=Array.isArray||function(e){return"Array"==a(e)}},fb6a:function(e,t,r){"use strict";var a=r("23e7"),o=r("861d"),n=r("e8b5"),i=r("23cb"),s=r("50c4"),l=r("fc6a"),c=r("8418"),d=r("b622"),u=r("1dde"),m=r("ae40"),f=u("slice"),p=m("slice",{ACCESSORS:!0,0:0,1:2}),h=d("species"),g=[].slice,v=Math.max;a({target:"Array",proto:!0,forced:!f||!p},{slice:function(e,t){var r,a,d,u=l(this),m=s(u.length),f=i(e,m),p=i(void 0===t?m:t,m);if(n(u)&&(r=u.constructor,"function"!=typeof r||r!==Array&&!n(r.prototype)?o(r)&&(r=r[h],null===r&&(r=void 0)):r=void 0,r===Array||void 0===r))return g.call(u,f,p);for(a=new(void 0===r?Array:r)(v(p-f,0)),d=0;f<p;f++,d++)f in u&&c(a,d,u[f]);return a.length=d,a}})},fdbc:function(e,t){e.exports={CSSRuleList:0,CSSStyleDeclaration:0,CSSValueList:0,ClientRectList:0,DOMRectList:0,DOMStringList:0,DOMTokenList:1,DataTransferItemList:0,FileList:0,HTMLAllCollection:0,HTMLCollection:0,HTMLFormElement:0,HTMLSelectElement:0,MediaList:0,MimeTypeArray:0,NamedNodeMap:0,NodeList:1,PaintRequestList:0,Plugin:0,PluginArray:0,SVGLengthList:0,SVGNumberList:0,SVGPathSegList:0,SVGPointList:0,SVGStringList:0,SVGTransformList:0,SourceBufferList:0,StyleSheetList:0,TextTrackCueList:0,TextTrackList:0,TouchList:0}}}]);
//# sourceMappingURL=chunk-a4f596ec.8035eebe.js.map