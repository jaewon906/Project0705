import style from "../css/boardMain.module.css"
import {Link} from "react-router-dom";
export default function BoardMain(){
    return(
        <form action="/board" method="post">
        <div className={style.container}>
            <div className={style.main}>
                <h1>전체 게시글</h1>
                <div className={style.category}>
                    <Link to="category=1"><div>자유게시판</div></Link>
                    <Link to="category=2"><div>공략게시판</div></Link>
                    <Link to="category=4"><div>공부게시판</div></Link>
                    <Link to="category=3"><div>꿀팁게시판</div></Link>
                </div>
                <div>
                    게시판 공간
                </div>
            </div>
        </div>
        </form>
    )
}