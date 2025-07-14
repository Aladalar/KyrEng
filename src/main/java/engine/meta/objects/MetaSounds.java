    package engine.meta.objects;

    public class MetaSounds {
        
        String type,file;
        float volume, pitch, delay, loopDelay;
        boolean loop;

        public MetaSounds(String type, String file, float volume, float pitch, float delay, float loopDelay, boolean loop) {
            this.type = type;
            this.file = file;
            this.volume = volume;
            this.pitch = pitch;
            this.delay = delay;
            this.loopDelay = loopDelay;
            this.loop = loop;
        }

        @Override
        public String toString() {
            return "MetaSounds [type=" + type + ", file=" + file + ", volume=" + volume + ", pitch=" + pitch
                    + ", delay=" + delay + ", loopDelay=" + loopDelay + ", loop=" + loop + "]";
        }

        
    }
