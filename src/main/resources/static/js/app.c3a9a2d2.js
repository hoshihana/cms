(function(e){function n(n){for(var c,a,o=n[0],i=n[1],h=n[2],d=0,l=[];d<o.length;d++)a=o[d],Object.prototype.hasOwnProperty.call(u,a)&&u[a]&&l.push(u[a][0]),u[a]=0;for(c in i)Object.prototype.hasOwnProperty.call(i,c)&&(e[c]=i[c]);f&&f(n);while(l.length)l.shift()();return r.push.apply(r,h||[]),t()}function t(){for(var e,n=0;n<r.length;n++){for(var t=r[n],c=!0,a=1;a<t.length;a++){var o=t[a];0!==u[o]&&(c=!1)}c&&(r.splice(n--,1),e=i(i.s=t[0]))}return e}var c={},a={app:0},u={app:0},r=[];function o(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-0d391134":"56d61f2e","chunk-115a89e9":"7716926f","chunk-179f1819":"c3653e39","chunk-1a97c474":"8bafeed4","chunk-1ac2f7e5":"365fde8e","chunk-2b9e83b6":"d223eab6","chunk-2d0b1a22":"ac91ec73","chunk-30ca28f2":"8dfc149a","chunk-35e0e8ce":"37809456","chunk-40fba06e":"fb32d7fc","chunk-4260606a":"8881e4db","chunk-4809d2e3":"410f6fd1","chunk-495f3b2c":"031eeea8","chunk-4ea51149":"ba859953","chunk-505d5ee5":"0581ba78","chunk-598912c9":"a1224984","chunk-603d3d2e":"90421b45","chunk-669f878c":"dd501a2b","chunk-6c9bdc08":"c5529537","chunk-77ea9be8":"5ec7bbc5","chunk-7fa49b63":"3da62cdc","chunk-8e043030":"c29d9a0e","chunk-981c9a1e":"877daf25","chunk-a4f596ec":"8035eebe","chunk-c172b60e":"41389259","chunk-e4095d7e":"e4daba37","chunk-e8d5b136":"701f46b7"}[e]+".js"}function i(n){if(c[n])return c[n].exports;var t=c[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,i),t.l=!0,t.exports}i.e=function(e){var n=[],t={"chunk-0d391134":1,"chunk-115a89e9":1,"chunk-179f1819":1,"chunk-1a97c474":1,"chunk-1ac2f7e5":1,"chunk-2b9e83b6":1,"chunk-30ca28f2":1,"chunk-35e0e8ce":1,"chunk-40fba06e":1,"chunk-4260606a":1,"chunk-4809d2e3":1,"chunk-495f3b2c":1,"chunk-4ea51149":1,"chunk-505d5ee5":1,"chunk-598912c9":1,"chunk-603d3d2e":1,"chunk-669f878c":1,"chunk-6c9bdc08":1,"chunk-77ea9be8":1,"chunk-7fa49b63":1,"chunk-8e043030":1,"chunk-981c9a1e":1,"chunk-a4f596ec":1,"chunk-c172b60e":1,"chunk-e4095d7e":1,"chunk-e8d5b136":1};a[e]?n.push(a[e]):0!==a[e]&&t[e]&&n.push(a[e]=new Promise((function(n,t){for(var c="css/"+({}[e]||e)+"."+{"chunk-0d391134":"0d7a0da2","chunk-115a89e9":"a29621c0","chunk-179f1819":"fd4b9565","chunk-1a97c474":"6d92b764","chunk-1ac2f7e5":"34b51280","chunk-2b9e83b6":"86058575","chunk-2d0b1a22":"31d6cfe0","chunk-30ca28f2":"732c8b45","chunk-35e0e8ce":"65a13a20","chunk-40fba06e":"c5fb931d","chunk-4260606a":"67e26815","chunk-4809d2e3":"f989a8cf","chunk-495f3b2c":"65a13a20","chunk-4ea51149":"621f09ec","chunk-505d5ee5":"17651b6b","chunk-598912c9":"74884cef","chunk-603d3d2e":"3d573412","chunk-669f878c":"db73f62d","chunk-6c9bdc08":"65a13a20","chunk-77ea9be8":"0603b950","chunk-7fa49b63":"6863ad44","chunk-8e043030":"65a13a20","chunk-981c9a1e":"247edb04","chunk-a4f596ec":"4c4dccf3","chunk-c172b60e":"a12aec7f","chunk-e4095d7e":"384d2705","chunk-e8d5b136":"db770b8f"}[e]+".css",u=i.p+c,r=document.getElementsByTagName("link"),o=0;o<r.length;o++){var h=r[o],d=h.getAttribute("data-href")||h.getAttribute("href");if("stylesheet"===h.rel&&(d===c||d===u))return n()}var l=document.getElementsByTagName("style");for(o=0;o<l.length;o++){h=l[o],d=h.getAttribute("data-href");if(d===c||d===u)return n()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=n,f.onerror=function(n){var c=n&&n.target&&n.target.src||u,r=new Error("Loading CSS chunk "+e+" failed.\n("+c+")");r.code="CSS_CHUNK_LOAD_FAILED",r.request=c,delete a[e],f.parentNode.removeChild(f),t(r)},f.href=u;var p=document.getElementsByTagName("head")[0];p.appendChild(f)})).then((function(){a[e]=0})));var c=u[e];if(0!==c)if(c)n.push(c[2]);else{var r=new Promise((function(n,t){c=u[e]=[n,t]}));n.push(c[2]=r);var h,d=document.createElement("script");d.charset="utf-8",d.timeout=120,i.nc&&d.setAttribute("nonce",i.nc),d.src=o(e);var l=new Error;h=function(n){d.onerror=d.onload=null,clearTimeout(f);var t=u[e];if(0!==t){if(t){var c=n&&("load"===n.type?"missing":n.type),a=n&&n.target&&n.target.src;l.message="Loading chunk "+e+" failed.\n("+c+": "+a+")",l.name="ChunkLoadError",l.type=c,l.request=a,t[1](l)}u[e]=void 0}};var f=setTimeout((function(){h({type:"timeout",target:d})}),12e4);d.onerror=d.onload=h,document.head.appendChild(d)}return Promise.all(n)},i.m=e,i.c=c,i.d=function(e,n,t){i.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,n){if(1&n&&(e=i(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(i.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var c in e)i.d(t,c,function(n){return e[n]}.bind(null,c));return t},i.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(n,"a",n),n},i.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},i.p="/",i.oe=function(e){throw console.error(e),e};var h=window["webpackJsonp"]=window["webpackJsonp"]||[],d=h.push.bind(h);h.push=n,h=h.slice();for(var l=0;l<h.length;l++)n(h[l]);var f=d;r.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("56d7")},"034f":function(e,n,t){"use strict";t("5a56")},"56d7":function(e,n,t){"use strict";t.r(n);t("e260"),t("e6cf"),t("cca6"),t("a79d");var c=t("a026"),a=t("f825"),u=t.n(a),r=(t("f8ce"),t("bc3a")),o=t.n(r),i=(t("d3b7"),t("8c4f"));c["default"].use(i["a"]);var h=function(){return t.e("chunk-505d5ee5").then(t.bind(null,"d504"))},d=function(){return t.e("chunk-e4095d7e").then(t.bind(null,"dab6"))},l=function(){return t.e("chunk-603d3d2e").then(t.bind(null,"ba5b"))},f=function(){return t.e("chunk-c172b60e").then(t.bind(null,"7c54"))},p=function(){return t.e("chunk-8e043030").then(t.bind(null,"6fff"))},s=function(){return t.e("chunk-179f1819").then(t.bind(null,"443d"))},b=function(){return t.e("chunk-0d391134").then(t.bind(null,"0356"))},k=function(){return t.e("chunk-598912c9").then(t.bind(null,"590f"))},m=function(){return t.e("chunk-1ac2f7e5").then(t.bind(null,"72b0"))},g=function(){return t.e("chunk-30ca28f2").then(t.bind(null,"d7ef"))},v=function(){return t.e("chunk-4809d2e3").then(t.bind(null,"c839"))},y=function(){return t.e("chunk-1a97c474").then(t.bind(null,"2593"))},w=function(){return t.e("chunk-7fa49b63").then(t.bind(null,"50ae"))},x=function(){return t.e("chunk-6c9bdc08").then(t.bind(null,"25bc"))},L=function(){return t.e("chunk-4ea51149").then(t.bind(null,"20ca"))},O=function(){return t.e("chunk-669f878c").then(t.bind(null,"6ca4"))},j=function(){return t.e("chunk-77ea9be8").then(t.bind(null,"3c47"))},E=function(){return t.e("chunk-35e0e8ce").then(t.bind(null,"22ab"))},B=function(){return t.e("chunk-115a89e9").then(t.bind(null,"0a09"))},S=function(){return t.e("chunk-4260606a").then(t.bind(null,"3c19"))},_=function(){return t.e("chunk-40fba06e").then(t.bind(null,"de51"))},P=function(){return t.e("chunk-2b9e83b6").then(t.bind(null,"b0d9"))},T=function(){return t.e("chunk-981c9a1e").then(t.bind(null,"496b"))},A=function(){return t.e("chunk-a4f596ec").then(t.bind(null,"d8b7"))},C=function(){return t.e("chunk-2d0b1a22").then(t.bind(null,"214a"))},I=function(){return t.e("chunk-e8d5b136").then(t.bind(null,"0f25"))},M=function(){return t.e("chunk-495f3b2c").then(t.bind(null,"363b"))},N=new i["a"]({routes:[{path:"/",redirect:"/index"},{path:"/index",name:"主页",component:h,meta:{title:"Home--会务管理系统"}},{path:"/user/",redirect:"/user/home",component:d,meta:{login:!0,role:"user"},children:[{path:"home",component:l,meta:{title:"用户主页--会务管理系统"}},{path:"profile",component:f,meta:{title:"个人信息--会务管理系统"}},{path:"message",component:p,meta:{title:"个人信箱--会务管理系统"}}]},{path:"/conference/",redirect:"/conference/list",component:s,meta:{login:!0,role:"user"},children:[{path:"create",component:b,meta:{title:"创建会议--会务管理系统"}},{path:"list",component:k,meta:{title:"会议列表--会务管理系统"}},{path:"detail/:id",component:m,meta:{title:"会议详情--会务管理系统"}},{path:"participate/:id",component:g,meta:{title:"参加会议--会务管理系统"}}]},{path:"/hotel/",redirect:"/hotel/reservation",component:v,meta:{login:!0,role:"hotel"},children:[{path:"reservation/",component:w,meta:{title:"酒店预订--会务管理系统"}},{path:"profile",component:y,meta:{title:"酒店信息--会务管理系统"}},{path:"message",component:x,meta:{title:"酒店信箱--会务管理系统"}}]},{path:"/driver/",redirect:"/driver/reservation",component:L,meta:{login:!0,role:"driver"},children:[{path:"profile",component:O,meta:{title:"司机--会务管理系统"}},{path:"reservation",component:j,meta:{title:"预约--会务管理系统"}},{path:"message",component:E,meta:{title:"司机信箱--会务管理系统"}}]},{path:"/admin/",redirect:"/admin/home",component:B,meta:{login:!0,role:"admin"},children:[{path:"home",component:S,meta:{title:"管理员主页--会务管理系统"}},{path:"user",component:_,meta:{title:"用户管理--会务管理系统"}},{path:"conference",component:P,meta:{title:"会议管理--会务管理系统"}},{path:"hotel",component:T,meta:{title:"酒店管理--会务管理系统"}},{path:"driver",component:A,meta:{title:"司机管理--会务管理系统"}},{path:"personalInfo",component:I,meta:{title:"管理员信息--会务管理系统"}},{path:"message",component:M,meta:{title:"信箱--会务管理系统"}}]},{path:"/admin/system",component:C,meta:{title:"高级模式--会务管理系统",login:!0,role:"admin"}}]}),$=t("2f62"),q=t("bfa9");c["default"].use($["a"]);var U=new q["a"]({storage:window.localStorage}),D=new $["a"].Store({plugins:[U.plugin],state:{username:"",token:"",role:"",accountId:""},mutations:{setUsername:function(e,n){e.username=n},setToken:function(e,n){e.token=n},setRole:function(e,n){e.role=n},setAccountId:function(e,n){e.accountId=n}}}),H=D,J=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},R=[],F={name:"App",components:{}},K=F,z=(t("034f"),t("0c7c")),G=Object(z["a"])(K,J,R,!1,null,null,null),Q=G.exports;c["default"].prototype.$axios=o.a,c["default"].prototype.$baseURI="",c["default"].use(u.a),c["default"].config.productionTip=!1,o.a.interceptors.request.use((function(e){return e.headers.common["token"]=H.state.token||"",e})),N.beforeEach((function(e,n,t){if(0===e.matched.length)return u.a.LoadingBar.start(),t("/index"),void u.a.LoadingBar.finish();u.a.LoadingBar.finish(),e.meta.title&&(document.title=e.meta.title),u.a.LoadingBar.start(),e.matched[0].meta.login?H.state.token?H.state.role!==e.matched[0].meta.role?(t("/index"),u.a.LoadingBar.finish(),u.a.Message.error("当前登录的用户角色与要访问的资源不符")):(t(),u.a.LoadingBar.finish()):(t("/index"),u.a.LoadingBar.finish(),u.a.Message.error("当前未登录, 请登录后继续")):(t(),u.a.LoadingBar.finish())})),N.afterEach((function(){})),new c["default"]({el:"#app",router:N,store:H,render:function(e){return e(Q)}}).$mount("#app")},"5a56":function(e,n,t){}});
//# sourceMappingURL=app.c3a9a2d2.js.map