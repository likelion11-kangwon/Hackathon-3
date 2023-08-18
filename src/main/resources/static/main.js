const intro = document.querySelector('.introduce');
const mentoring = document.querySelector('.mentoring');
const test = document.querySelector('.test');

const introBL = document.querySelector('.introduce-block');
const menNO = document.querySelector('.mentoring-none');
const testNO = document.querySelector('.test-none');

intro.addEventListener('click',function(){
  introBL.classList.add('introduce-block');
  introBL.classList.remove('introduce-none');

  menNO.classList.add('mentoring-none');
  menNO.classList.remove('mentoring-block');

  testNO.classList.add('test-none');
  testNO.classList.remove('test-block');
})

mentoring.addEventListener('click',function(){
  introBL.classList.add('introduce-none');
  introBL.classList.remove('introduce-block');

  menNO.classList.add('mentoring-block');
  menNO.classList.remove('mentoring-none');

  testNO.classList.add('test-none');
  testNO.classList.remove('test-block');
})

test.addEventListener('click',function(){
  introBL.classList.add('introduce-none');
  introBL.classList.remove('introduce-block');

  menNO.classList.add('mentoring-none');
  menNO.classList.remove('mentoring-block');

  testNO.classList.add('test-block');
  testNO.classList.remove('test-none');
})




const stateName = document.querySelector('.mentoring-state-name');
const corporationName = document.querySelector('.mentoring-corporation-name');

const stateContent = document.querySelector('.mentoring-state-content');
const corporationContent = document.querySelector('.mentoring-corporation-content');



stateName.addEventListener('click',function(){
  stateContent.classList.add('mentoring-state-content');
  corporationContent.classList.remove('mentoring-corporation-content-block');

  stateContent.classList.remove('mentoring-state-content-none');
  corporationContent.classList.add('mentoring-corporation-content');
})

corporationName.addEventListener('click',function(){
  stateContent.classList.add('mentoring-state-content-none');
  corporationContent.classList.remove('mentoring-corporation-content');

  stateContent.classList.remove('mentoring-state-content');
  corporationContent.classList.add('mentoring-corporation-content-block');
})



// 추가
const state = document.querySelector('.mentoring-state-name');

state.addEventListener('click',function(){
  state.setAttribute('transfrom','scale(1.3)');
  state.setAttribute('background-color','#6ff4bd')
})


const corporation = document.querySelector('.mentoring-corporation-name');

corporation.addEventListener('click',function(){
  corporation.setAttribute('transfrom','scale(1.3)');
  corporation.setAttribute('background-color','#f9c786')
})


