package org.mert.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterResponseDto {
    Long authid;
    String content;
    String email;
    /*
     100- Kayıt başarılı
     200- Kayıt beklemede
     300- Hata
     400-
     */
    Integer registerstate;
}
