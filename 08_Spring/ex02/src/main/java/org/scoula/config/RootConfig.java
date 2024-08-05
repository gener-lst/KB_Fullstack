package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @configuration
@Configuration
@ComponentScan(basePackages = {"org.scoula"})
// 해당 패키지 내 경로에서 @Component 어노테이션을 자동으로 찾아 등록
// Spring의 경우 context 레벨에서 bean 이름으로 찾을 수 있는 컴포넌트의 경우 singleton 운영
public class RootConfig {
}
