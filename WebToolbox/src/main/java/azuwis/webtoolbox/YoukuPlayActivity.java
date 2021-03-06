package azuwis.webtoolbox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class YoukuPlayActivity extends BasePlayActivity {

    @Override
    protected String getPlayUrl(String url) {
        Pattern pattern = Pattern.compile(".*/id_([A-Za-z0-9]+)\\.html.*");
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            return String.format("http://v.youku.com/player/getRealM3U8/vid/%s/type/%s/v.m3u8",
                    matcher.group(1), getType());
        } else {
            return null;
        }
    }

    protected abstract String getType();

}
