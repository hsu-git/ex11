<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>요청 객체 다루기</title>
    <style>
        @font-face {
            font-family: 'BagelFatOne-Regular';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_JAMO@1.0/BagelFatOne-Regular.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
        @font-face {
            font-family: 'Ownglyph_ParkDaHyun';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2411-3@1.0/Ownglyph_ParkDaHyun.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
        * {
            font-family: BagelFatOne-Regular, serif;
            font-size: large;
            padding: 0;
            margin: 0;
        }
        .title {
            font-family: Ownglyph_ParkDaHyun, serif;
        }
        form {
            width : 100%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            gap: 1rem;
        }
        form * {
            width: 50%;
        }
    </style>
</head>
<body>
    <form>
        <section>
            프롬프트 : <%= request.getParameter("prompt") %>
        </section>
        <input class="title" name="prompt" placeholder="프롬프트를 입력해주세요.">
        <button>submit</button>
    </form>
</body>
</html>