<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="CWrap" id="CWrap">
		<div class="Container">
			<h3>■회원 정보</h3>

			<div class="BasicVW">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th style="width: 100px">아이디</th>
							<td><input name="txtUserId" type="text" id="txtUserId"
								onkeypress="if(event.keyCode==13){Search(); return false;}">
							</td>
							<th style="width: 100px">이름</th>
							<td><input name="txtUserNm" type="text" id="txtUserNm"
								onkeypress="if(event.keyCode==13){Search(); return false;}">

							</td>
							<th style="width: 100px">Email</th>
							<td><input name="txtEmail" type="text" id="txtEmail"
								onkeypress="if(event.keyCode==13){Search(); return false;}">
							</td>
						</tr>
						<tr>
							<th>HP 뒷자리</th>
							<td><input name="txtHp" type="text" id="txtHp"
								onkeypress="if(event.keyCode==13){Search(); return false;}">
							</td>
							<th>상태</th>
							<td><select name="ddlStatus" id="ddlStatus">
									<option selected="selected" value="">전체</option>
									<option value="I">가입</option>
									<option value="D">휴면</option>
									<option value="E">탈퇴</option>

							</select></td>
							<th>활동지역</th>
							<td><select name="ddlAreaList" id="ddlAreaList">
									<option selected="selected" value="0">지역</option>
									<option value="53">서울강북1</option>
									<option value="54">서울강북2</option>
									<option value="56">서울강남1</option>
									<option value="57">서울강남2</option>
									<option value="58">서울강남3</option>
									<option value="59">경기북부</option>
									<option value="60">경기남부1</option>
									<option value="61">경기남부2</option>
									<option value="62">경기남부3</option>
									<option value="63">인천</option>
									<option value="64">강원</option>
									<option value="65">대전</option>
									<option value="66">충북</option>
									<option value="67">충남</option>
									<option value="68">광주전남</option>
									<option value="69">전북</option>
									<option value="70">대구</option>
									<option value="71">경북</option>
									<option value="72">경남</option>
									<option value="73">울산</option>
									<option value="74">부산</option>
									<option value="75">제주</option>
									<option value="78">상계</option>
									<option value="77">본사</option>
									<option value="76">기타</option>

							</select></td>
						</tr>

						<tr>
							<th>가입일</th>
							<td colspan="3"><input name="txtSDtm" type="text"
								id="txtSDtm" readonly="ReadOnly"> ~ <input
								name="txtEDtm" type="text" id="txtEDtm" readonly="ReadOnly"></td>
							<th>가입사이트</th>
							<td><select name="ddlJoinSite" id="ddlJoinSite">
									<option selected="selected" value="">전체</option>
									<option value="BrainWorld">브레인월드</option>
									<option value="brEarthJr">brEarthJr</option>
									<option value="BrinEdu">BrinEdu</option>
									<option value="dahnworld">단월드</option>
									<option value="DotongSchool">도통스쿨</option>
									<option value="EarthCitizenPassPort">EarthCitizenPassPort</option>
									<option value="hsp.net">hsp.net</option>
									<option value="iearthcitizen">iearthcitizen</option>
									<option value="ilchiacademy">일지아카데미</option>
									<option value="ilchinet">일지넷</option>
									<option value="InsungKorea">인성코리아</option>
									<option value="kookhaknews">국학뉴스</option>
									<option value="LifeParticleTv">LifeParticleTv</option>
									<option value="MeditationClub">MeditationClub</option>

							</select></td>
						</tr>
						<tr>
							<th>뉴스레터 수신</th>
							<td><select name="ddlIsEmailSend" id="ddlIsEmailSend">
									<option selected="selected" value="">전체</option>
									<option value="Y">수신</option>
									<option value="N">미수신</option>

							</select></td>
							<th>SMS 수신</th>
							<td><select name="ddlIsSmsSend" id="ddlIsSmsSend">
									<option selected="selected" value="">전체</option>
									<option value="Y">수신</option>
									<option value="N">미수신</option>

							</select></td>
							<th>본인인증 상태</th>
							<td><select name="ddlUserValidCd" id="ddlUserValidCd">
									<option selected="selected" value="">전체</option>
									<option value="Y">인증</option>
									<option value="N">미인증</option>

							</select></td>
						</tr>
						<tr>
							<th>기수</th>
							<td colspan="5"><select name="ddlCardinalNum"
								id="ddlCardinalNum">
									<option selected="selected" value="">전체</option>
									<option value="1">1</option>
									<option value="1">2</option>

							</select></td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="검색"
					style="margin-top: 10px; width: 350px; cursor: pointer;"
					onclick="javascript:Search()"> <input type="button" name=""
					value="검색 결과 엑셀 다운로드" class="mgrayBtn10 fr" onclick="Excel();">
				<input type="button" name="" value="전체 다운로드" class="mgrayBtn10 fr"
					onclick="AllExcel();">
			</div>
			<br>

			<div class="BasicList">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>닉네임</th>
							<th>이메일</th>
							<th>휴대폰</th>
							<th>활동지역</th>
							<th>상태</th>
						</tr>

						<tr>
							<td>57</td>
							<td><a href="javascript:UserInfoView('whxoghks1', 'I')">whxoghks1</a></td>
							<td>조태환</td>
							<td>조태환</td>
							<td>01062744133@naver.com</td>
							<td>010-6275-4138</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>56</td>
							<td><a href="javascript:UserInfoView('abc17051709', 'D')">abc17051709</a></td>
							<td>김선희</td>
							<td>김선희</td>
							<td>sopinea@paran.com</td>
							<td>--</td>
							<td>미입력</td>
							<td>휴면</td>
						</tr>

						<tr>
							<td>55</td>
							<td><a href="javascript:UserInfoView('dkswhdgk445', 'I')">dkswhdgk445</a></td>
							<td>안종한</td>
							<td>안종한</td>
							<td>dkswhdgk4@naver.com</td>
							<td>010-2927-1872</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>54</td>
							<td><a href="javascript:UserInfoView('smile14email', 'I')">smile14email</a></td>
							<td>이지은</td>
							<td>이지은</td>
							<td>lje_smile1@hanmail.net</td>
							<td>010-2521-1233</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>53</td>
							<td><a href="javascript:UserInfoView('dkswhdgk444', 'I')">dkswhdgk444</a></td>
							<td>안종한</td>
							<td>안종한</td>
							<td>dkswhdgk2@naver.com</td>
							<td>010-9712-2345</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>52</td>
							<td><a href="javascript:UserInfoView('abc17051701', 'I')">abc17051701</a></td>
							<td>김선희</td>
							<td>김선희</td>
							<td>sopinerra@hanmail.net</td>
							<td>014-4777-78855</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>51</td>
							<td><a href="javascript:UserInfoView('dkswhdgk303', 'I')">dkswhdgk303</a></td>
							<td>안종한</td>
							<td>안종한</td>
							<td>dkswhdgk2@naver.com</td>
							<td>010-292-8374</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>50</td>
							<td><a href="javascript:UserInfoView('stonehead2233', 'I')">stonehead2233</a></td>
							<td>지성국</td>
							<td>지성국</td>
							<td>stonehead22@naver.com</td>
							<td>--</td>
							<td>미입력</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>49</td>
							<td><a href="javascript:UserInfoView('stonehead2222', 'I')">stonehead2222</a></td>
							<td>지성국</td>
							<td>지성국</td>
							<td>stonehead22@naver.com</td>
							<td>--</td>
							<td>경북</td>
							<td>가입</td>
						</tr>

						<tr>
							<td>48</td>
							<td><a href="javascript:UserInfoView('wjddy001', 'I')">wjddy001</a></td>
							<td>정의섭</td>
							<td>정의섭</td>
							<td>hiter00@empal.com</td>
							<td>--</td>
							<td>충남</td>
							<td>가입</td>
						</tr>

					</tbody>
				</table>
			</div>
			<div id="divPaging">
				<div class="Paging04">
					<a onclick="alert(&quot;이전 페이지가 없습니다.&quot;);" id="BeforeTag"
						style="cursor: pointer" class="Pre">이전</a><a onclick="Selected(1)"
						id="page1" class="On" style="cursor: pointer;">1</a><a id="page2"
						onclick="Selected(2)" style="cursor: pointer;">2</a><a id="page3"
						onclick="Selected(3)" style="cursor: pointer;">3</a><a id="page4"
						onclick="Selected(4)" style="cursor: pointer;">4</a><a id="page5"
						onclick="Selected(5)" style="cursor: pointer;">5</a><a id="page6"
						onclick="Selected(6)" style="cursor: pointer;">6</a><a
						onclick="alert(&quot;다음 페이지가 없습니다.&quot;);" id="NextTag"
						style="cursor: pointer" class="Next">다음</a>
				</div>
			</div>
		</div>

		<div style="display: none;"></div>


	</div>
</body>
</html>