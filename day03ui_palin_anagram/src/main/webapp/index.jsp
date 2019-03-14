<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        $().ready(() => {

            $('#palindromebutton').on("click", () => {
            let word = $('#word').val();
            if(word){
                $.ajax({
                    url: '/palindromecheck?word=' + word,
                    type: 'POST',
                    success(response) {
                        $('#palindromemessage').text(response);
                        $('#message').text("");
                    }
                })
            }
            else{
                $('#message').text("Please enter something in the text box");
            }
        });

        $('#anagrambutton').on("click", () => {
            let word = $('#word').val();
            if(word){
                $.ajax({
                    url: '/getanagram?word=' + word,
                    type: 'POST',
                    success(response) {
                        $('#anagrammessage').text(response);
                        $('#message').text("");
                    }
                })
            }
            else{
                $('#message').text("Please enter something in the text box");
            }
        });
        });
    </script>
</head>
<body>
<h1>Play with Words</h1>
Word <input type="text" id="word"> <br/><br/>
<h2 id="message"></h2>
<hr/>
<button type="button" id="palindromebutton">Check Palindrome</button>
<button type="button" id="anagrambutton">Get Anagram</button>
<h2 id="palindromemessage"></h2>
<h2 id="anagrammessage"></h2>
</body>
</html>

<%--INDEX>JSP WITHOUT JQUERY--%>
<%--<html>--%>
<%--<body>--%>
<%--<h1>Play with Words</h1>--%>
<%--<form action="/palindromecheck" method="POST">--%>
<%--Word <input type="text" name="word">--%>
<%--<br/>--%>
<%--<button>Check Palindrome</button>--%>
<%--<h2>${palindromemessage}</h2>--%>
<%--<h2>${message}</h2>--%>
<%--</form>--%>
<%--<hr/>--%>
<%--<form action="/getanagram" method="POST">--%>
<%--Word <input type="text" name="word">--%>
<%--<br/>--%>
<%--<button>Get Anagram</button>--%>
<%--<h2>${anagrammessage}</h2>--%>
<%--<h2>${message}</h2>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>