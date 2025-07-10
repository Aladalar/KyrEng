    package game.scene;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import engine.entity.Entity;
    import engine.maps.MapLayer;
    import engine.maps.Scene;;

    public class SimpleScene extends Scene {

        public SimpleScene() {
            super("test_scene", getMapLayers(),  getEntity(), null, null, true);
        }

        private static MapLayer getMapLayers(){
                Map<Integer, String> mapLay = new HashMap<>();
                mapLay.put(250, "algae.png");
                return new MapLayer(0, "test", mapLay);
        }

        private static  List<Entity> getEntity(){
            return null;
        }

        @Override
        public void load(){
            return;
        }
        @Override
        public void unload() {
            return;
        }

        @Override
        public List<Entity> getEntities(){
            return null;
        }

        @Override
        public void getZSortedLayers(){
            return;
        }

        @Override
        public List<String> getEntryPoint(){
            return null;
        }
        @Override
        public String getNavMap(){
            return null;
        }

        @Override
        public String getPOIs(){
            return null;
        }
    }
