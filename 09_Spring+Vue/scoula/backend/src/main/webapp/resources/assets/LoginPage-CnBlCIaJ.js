import{u as f,a as b,r as h,b as v,c as g,o as n,d as c,e as s,w as i,v as d,t as w,f as y,g as o,h as x}from"./index-BMaia25B.js";const k={class:"mt-5 mx-auto",style:{width:"500px"}},V=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-right-to-bracket"}),o(" 로그인 ")],-1),D={class:"mb-3 mt-3"},S=s("label",{for:"username",class:"form-label"},[s("i",{class:"fa-solid fa-user"}),o(" 사용자 ID: ")],-1),B={class:"mb-3"},N=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),o(" 비밀번호: ")],-1),I={key:0,class:"text-danger"},M=["disabled"],T=s("i",{class:"fa-solid fa-right-to-bracket"},null,-1),C={__name:"LoginPage",setup(U){const u=f(),m=b(),e=h({username:"",password:""}),a=v(""),p=g(()=>!(e.username&&e.password)),_=async()=>{console.log(e);try{await m.login(e),u.push("/")}catch(l){console.log("에러=======",l),a.value=l.response.data}};return(l,t)=>(n(),c("div",k,[V,s("form",{onSubmit:x(_,["prevent"])},[s("div",D,[S,i(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID","onUpdate:modelValue":t[0]||(t[0]=r=>e.username=r)},null,512),[[d,e.username]])]),s("div",B,[N,i(s("input",{type:"password",class:"form-control",placeholder:"비밀번호","onUpdate:modelValue":t[1]||(t[1]=r=>e.password=r)},null,512),[[d,e.password]])]),a.value?(n(),c("div",I,w(a.value),1)):y("",!0),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:p.value},[T,o(" 로그인 ")],8,M)],32)]))}};export{C as default};