package board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BoardDTO {
	private int bno;
	private String name;
	private String password;
	private String title;
	private String content;
	private String attach;
	private int re_Ref;
	private int re_Lev;
	private int re_Seq;
	private int readCount;
	private Date regDate;  
}
