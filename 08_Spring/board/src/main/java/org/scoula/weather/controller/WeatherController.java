package org.scoula.weather.controller;

import lombok.extern.slf4j.Slf4j;
import org.scoula.weather.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@Slf4j
@RequestMapping("/weather")
@PropertySource({"classpath:/application.properties"})
public class WeatherController {
    @Value("${weather.url}")
    private String URL;

    @Value("${weather.icon_url}")
    private String ICON_URL;

    @Value("${weather.api_key}")
    private String API_KEY;

    @GetMapping({"", "/{city}"}) // 주소 형식이 /weather, /weather/{city}로 올 경우 둘 다 처리
    public String weather(Model model, @PathVariable(value="city", required = false) String city) { // required = false로 주면 해당 값이 옵션 처리된다.
        city = city == null ? "seoul" : city;
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString(); // 기본 URL에 쿼리스트링을 연결해서 새로운 주소 생성
        WeatherDTO weather = restTemplate.getForObject(url, WeatherDTO.class);
        // 생성한 url을 통해서 weatherDTO 결과값 반환 받아옴
        String iconUrl = ICON_URL.formatted(weather.getWeather().get(0).getIcon());
        // weatherDTO의 weather -> weatherItem의 리스트 중 첫번째 아이템의 아이콘으로 ICON_URL 포멧
        log.info("오늘의 날씨: " + weather);

        // view 쪽에서 사용하기 위해 model에 데이터 저장
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        model.addAttribute("iconUrl", iconUrl);
        // @Controller에서는 리턴값이 곧 뷰 이름이 됨
        return "weather/today";
    }
}

