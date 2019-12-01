<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>PGCD : ${pgcd.calculatePgcd(pgcd.getEntier1(),pgcd.getEntier2())} </h5>
<h5>PPCM : ${ppcm.calculatePpcm(pgcd.getEntier1(),pgcd.getEntier2())} </h5> 
Entrées  : <p>${pgcd.getEntier1()} , ${pgcd.getEntier2()}<p>
</body>
</html>