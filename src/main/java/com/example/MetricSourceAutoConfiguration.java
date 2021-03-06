package com.example;

import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.repository.MetricRepository;
import org.springframework.boot.actuate.metrics.repository.redis.RedisMetricRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@ConditionalOnMissingBean (MetricRepository.class)
public class MetricSourceAutoConfiguration {

	@Bean
	@ExportMetricWriter
	@ExportMetricReader
	public MetricRepository metricRepository(RedisConnectionFactory factory) {
		return new RedisMetricRepository(factory);
	}
}
