package miu.waa.xuanloc.lab1.waalab1.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PostEntity {
    private long id;
    private String title;
    private String content;
    private String author;

}
