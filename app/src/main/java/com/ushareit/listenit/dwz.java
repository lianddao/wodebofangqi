package com.ushareit.listenit;

import com.mopub.common.Constants;
import com.umeng.analytics.C0154a;

public final class dwz {
    public static dxa<Long> f10506A = dxa.m16171a("measurement.upload.initial_upload_delay_time", 15000);
    public static dxa<Long> f10507B = dxa.m16171a("measurement.upload.retry_time", 1800000);
    public static dxa<Integer> f10508C = dxa.m16169a("measurement.upload.retry_count", 6);
    public static dxa<Long> f10509D = dxa.m16171a("measurement.upload.max_queue_time", 2419200000L);
    public static dxa<Integer> f10510E = dxa.m16169a("measurement.lifetimevalue.max_currency_tracked", 4);
    public static dxa<Integer> f10511F = dxa.m16169a("measurement.audience.filter_result_max_count", 200);
    public static dxa<Long> f10512G = dxa.m16171a("measurement.service_client.idle_disconnect_millis", 5000);
    public static dxa<Boolean> f10513a = dxa.m16175a("measurement.service_enabled", true);
    public static dxa<Boolean> f10514b = dxa.m16175a("measurement.service_client_enabled", true);
    public static dxa<String> f10515c = dxa.m16174a("measurement.log_tag", "FA", "FA-SVC");
    public static dxa<Long> f10516d = dxa.m16171a("measurement.ad_id_cache_time", 10000);
    public static dxa<Long> f10517e = dxa.m16171a("measurement.monitoring.sample_period_millis", (long) C0154a.f2953i);
    public static dxa<Long> f10518f = dxa.m16172a("measurement.config.cache_time", (long) C0154a.f2953i, (long) C0154a.f2954j);
    public static dxa<String> f10519g = dxa.m16173a("measurement.config.url_scheme", Constants.HTTPS);
    public static dxa<String> f10520h = dxa.m16173a("measurement.config.url_authority", "app-measurement.com");
    public static dxa<Integer> f10521i = dxa.m16169a("measurement.upload.max_bundles", 100);
    public static dxa<Integer> f10522j = dxa.m16169a("measurement.upload.max_batch_size", 65536);
    public static dxa<Integer> f10523k = dxa.m16169a("measurement.upload.max_bundle_size", 65536);
    public static dxa<Integer> f10524l = dxa.m16169a("measurement.upload.max_events_per_bundle", 1000);
    public static dxa<Integer> f10525m = dxa.m16169a("measurement.upload.max_events_per_day", 100000);
    public static dxa<Integer> f10526n = dxa.m16169a("measurement.upload.max_error_events_per_day", 1000);
    public static dxa<Integer> f10527o = dxa.m16169a("measurement.upload.max_public_events_per_day", 50000);
    public static dxa<Integer> f10528p = dxa.m16169a("measurement.upload.max_conversions_per_day", 500);
    public static dxa<Integer> f10529q = dxa.m16169a("measurement.upload.max_realtime_events_per_day", 10);
    public static dxa<Integer> f10530r = dxa.m16169a("measurement.store.max_stored_events_per_app", 100000);
    public static dxa<String> f10531s = dxa.m16173a("measurement.upload.url", "https://app-measurement.com/a");
    public static dxa<Long> f10532t = dxa.m16171a("measurement.upload.backoff_period", 43200000);
    public static dxa<Long> f10533u = dxa.m16171a("measurement.upload.window_interval", (long) C0154a.f2954j);
    public static dxa<Long> f10534v = dxa.m16171a("measurement.upload.interval", (long) C0154a.f2954j);
    public static dxa<Long> f10535w = dxa.m16171a("measurement.upload.realtime_upload_interval", 10000);
    public static dxa<Long> f10536x = dxa.m16171a("measurement.upload.minimum_delay", 500);
    public static dxa<Long> f10537y = dxa.m16171a("measurement.alarm_manager.minimum_interval", 60000);
    public static dxa<Long> f10538z = dxa.m16171a("measurement.upload.stale_data_deletion_interval", (long) C0154a.f2953i);
}
