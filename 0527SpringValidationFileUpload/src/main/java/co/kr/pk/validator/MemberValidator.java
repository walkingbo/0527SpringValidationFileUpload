package co.kr.pk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.kr.pk.domain.Member;

public class MemberValidator implements Validator {
	
	//유효성 검사를 수행할 클래스를 설정하는 메소드 
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
	
	//실제 유효성 검사를 수행할 메소드 
	@Override
	public void validate(Object target, Errors errors) {
		//매개변수로 전달된 target을 유효성 검사를 수행할 객체로 변환
		Member member = (Member) target;
		//id 유효성 검사
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required.id");
		// pw 유효성 검사
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required.pw");
		
		if (member.getPw().trim().length() < 8 || member.getPw().trim().length() > 15) {
			errors.rejectValue("pw", "length");
		}
		// nickname 유효성 검사
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "required.nickname");
		}
	}


