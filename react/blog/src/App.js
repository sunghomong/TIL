import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let post = '강남 우동 맛집'; // 서버에서 가져온 데이터라고 가정
  // document.querySelector('h4').innerHTML = post; 기존의 js 스타일
  let [글제목, b] = useState(['남자 코트 추천','강남 우동맛집','파이썬독학']); // b = state 변경도와주는 함수
  // 글제목 = '남자 코트 추천' , b = 함수
  let [logo, setLogo] = useState('ReactBlog'); // 사이트 로고는 굳이 state를 쓸필요 없다

// Destructuring 문법
  let num = [1, 2];

  let [a, c] = [1, 2]; // a = 1 , c = 2

  // let a = num[0]; // 1
  // let c = num[1]; // 2

  // state 를 쓰는 이유 : 변수를 화면상에 랜더링이 안되기 때문에 state는 html전체가 자동 재랜더링이 됨
  // state는 자주 변경될거같은 html 부분을 state로 만든다.
  return (
    <div className="App">
      <div className='black-nav'>
        <h4>ReactBlog</h4>
      </div>
      <div className='list'>
        <h4>{ 글제목[0] }</h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4>{ 글제목[1] }</h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4>{ 글제목[2] }</h4>
        <p>2월 17일 발행</p>
      </div>
    </div>
  );
}

export default App;
