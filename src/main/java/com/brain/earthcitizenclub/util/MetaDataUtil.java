package com.brain.earthcitizenclub.util;

import org.springframework.ui.Model;

public class MetaDataUtil {
	
	public String setMataData(String type,Model model){
		
		StringBuffer sb = new StringBuffer();
		
		if(type.equals("main")){
			sb.append("<meta name='title' content= '대한민국역사진단학회'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회'/>"+"\n");
			sb.append("<meta name='Keywords' content= '대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성,학회소개,세미나,학회자료실,정치,정책,인성진흥법'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회는 한민족의 역사를 통해 현재를 진단하고, 미래 대안을 제시하기 위해 만들어진 학회입니다.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회는 한민족의 역사를 통해 현재를 진단하고, 미래 대안을 제시하기 위해 만들어진 학회입니다.'/>"+"\n");

		}else if(type.equals("introduce")){			
			sb.append("<meta name='title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='Keywords' content= '학회소개,대표인사말,조직도,회칙,인사말,소개,안내,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
					
		}else if(type.equals("organization")){
			
			sb.append("<meta name='title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='Keywords' content= '학회소개,대표인사말,조직도,회칙,인사말,소개,안내,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
						
		}else if(type.equals("rule")){
							
			sb.append("<meta name='title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 학회소개'/>"+"\n");
			sb.append("<meta name='Keywords' content= '학회소개,대표인사말,조직도,회칙,인사말,소개,안내,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회를 소개합니다. 대표인사말, 조직도, 회칙을 확인하세요.'/>"+"\n");
					
		}
		
		else if(type.equals("academy")){
			
			sb.append("<meta name='title' content= '대한민국역사진단학회 학회자료실'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 학회자료실'/>"+"\n");
			sb.append("<meta name='Keywords' content= '학회자료실,자료실,학회자료,자료,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회 자료실입니다.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회 자료실입니다.'/>"+"\n");
			
			
		}else if(type.equals("seminar")){
			
			sb.append("<meta name='title' content= '대한민국역사진단학회 세미나'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 세미나'/>"+"\n");
			sb.append("<meta name='Keywords' content= '세미나,세미나신청,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회에서 진행하는 세미나에 참여하세요.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회에서 진행하는 세미나에 참여하세요.'/>"+"\n");
					
		}else if(type.equals("notice")){	
			
			sb.append("<meta name='title' content= '대한민국역사진단학회 공지사항'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 공지사항'/>"+"\n");
			sb.append("<meta name='Keywords' content= '공지사항,공지,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회 공지입니다.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회 공지입니다.'/>"+"\n");
				
		}else if(type.equals("contactUs")){		
			
			sb.append("<meta name='title' content= '대한민국역사진단학회 문의하기'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 문의하기'/>"+"\n");
			sb.append("<meta name='Keywords' content= '문의하기,문의,고객센터,고객문의,질문,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성'/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회 문의하기 페이지입니다.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회 문의하기 페이지입니다.'/>"+"\n");
						
		}else if(type.equals("Normal") || type.equals("Org")){
			//회원가입			
			sb.append("<meta name='title' content= '대한민국역사진단학회 회원가입'/>"+"\n");
			sb.append("<meta name='og:title' content= '대한민국역사진단학회 회원가입'/>"+"\n");
			sb.append("<meta name='Keywords' content= '회원가입,개인회원,기업회원,회원,가입,대한민국역사진단학회,역사진단학회,대역진회,역진회,역사,진단,인성/>"+"\n");
			sb.append("<meta name='Description' content= '대한민국역사진단학회 회원가입페이지입니다. 개인, 기업 모두 학회 회원으로 가입가능합니다.'/>"+"\n");
			sb.append("<meta name='og:description' content= '대한민국역사진단학회 회원가입페이지입니다. 개인, 기업 모두 학회 회원으로 가입가능합니다.'/>"+"\n");
					
		}		

		
		model.addAttribute("metaData", sb.toString());
		
		
		return "/common/top";
		
	}
}
