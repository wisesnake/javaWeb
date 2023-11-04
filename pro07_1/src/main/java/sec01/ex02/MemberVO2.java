package sec01.ex02;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Value Object, 밸류값 객체.
@Data // @Getter @Setter @ToString 대체
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO2 {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
}
