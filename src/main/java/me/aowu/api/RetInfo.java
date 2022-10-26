package me.aowu.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RetInfo {
    private String status;
    private String data;
}
