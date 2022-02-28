<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>DVD Library Application: Add DVD Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1> Add DVD </h1>
<form action='add_dvd.do' method='POST'>
    Title: <input type='text' name='title'><br/><br/>
    Year: <input type='text' name='year'><br/><br/>
    Genre: <select name='genre'>
    <option value='Sci-Fi'>Sci-Fi</option>
    <option value='Drama'>Drama</option>
    <option value='Comedy'>Comedy</option>
</select>
    or new genre: <input type='text' name='newGenre'><br/><br/>
    <input type='submit'>
</form>
</body>
</html>
