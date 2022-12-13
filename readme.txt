Final Project PBO

Game Flappy Bird
Pada game ini player harus mengarahkan karakter untuk melewati rintangan tanpa terjatuh dengan hati-hati. 'Karakter' akan lompat ketika ditekan dan akan jatuh bebas jika tidak ditekan. Jika player dapat mengenai objek tertentu maka akan dapat tambahan poin. Game akan berakhir jika 'karakter' mengenai rintangan atau jatuh. Skor tertinggi player akan dicatat. 

sumber referensi : https://github.com/FunGameDeveloperFGD/JavaGame_FlappyBird

Aspek OOP yang diterapkan :
1. Casting/Conversion (src/main/GamePanel.java)
        //casting
        if (backgroundBox.x + backgroundBox.getWidth() <= 0) {
            backgroundBox.x = (int) (backgroundBox.x + backgroundBox.getWidth());
        }


        if (floorBox.x + floorBox.getWidth() <= 0) {
            floorBox.x = (int) (floorBox.x + floorBox.getWidth());
        }
        
2. Constructor (src/main/Game.java, src/main/Obstacle)
      public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        topPipe = new Rectangle(x, y, width, height);
        bottomPipe = new Rectangle(x, height + distance, width, height);
    }
  
3. Overriding (src/main/GamePanel.java)
    @Override
    public void run() {
        try {
            requestFocus();
            start();
            while (isRunning) {
                update();
                draw();
                Thread.sleep(1000 / 60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
4. Inheritance (src/main/GamePanel.java)
//inheritance
public class GamePanel extends JPanel implements Runnable, MouseListener{

5. Exception Handling (src/main/GamePanel.java)
    public void start() {
        //exception handling
        try {
            view = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
            background = ImageIO.read(getClass().getResource("/assets/background.png"));
            floor = ImageIO.read(getClass().getResource("/assets/floor.png"));
            tapToStartTheGame = ImageIO.read(getClass().getResource("/assets/tap_to_start_the_game.png"));
            BufferedImage fly = ImageIO.read(getClass().getResource("/assets/flappy_sprite_sheet.png"));
            topPipe = ImageIO.read(getClass().getResource("/assets/top_pipe.png"));
            bottomPipe = ImageIO.read(getClass().getResource("/assets/bottom_pipe.png"));


            flyBirdAmin = new BufferedImage[3];
            for (int i = 0; i < 3; i++) {
                flyBirdAmin[i] = fly.getSubimage(i * 17, 0, 17, 12);
            }
            bird = flyBirdAmin[0];


            DISTORTION = (SIZE / background.getHeight());


            obstacles = new Obstacle[4];
            startPositionObstacles();


            int widthTapStartGame = tapToStartTheGame.getWidth() * DISTORTION;
            int heightTapStartGame = tapToStartTheGame.getHeight() * DISTORTION;
            tapToStartTheGameBox = new Rectangle(
                    (SIZE / 2) - (widthTapStartGame / 2),
                    (SIZE / 2) - (heightTapStartGame / 2),
                    widthTapStartGame,
                    heightTapStartGame
            );
            flappyBox = new Rectangle(
                    0,
                    0,
                    bird.getWidth() * DISTORTION,
                    bird.getHeight() * DISTORTION
            );
            backgroundBox = new Rectangle(
                    0,
                    0,
                    background.getWidth() * DISTORTION,
                    background.getHeight() * DISTORTION
            );
            floorBox = new Rectangle(
                    0,
                    SIZE - (floor.getHeight() * DISTORTION),
                    floor.getWidth() * DISTORTION,
                    floor.getHeight() * DISTORTION
            );


            startPositionFlappy();


            font = new Font("TimesRoman", Font.BOLD, 16 * DISTORTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

6. GUI (src/main/GameWindow.java)
   public class GameWindow {
    //GUI
    private JFrame w; 
    
    public GameWindow(GamePanel gamePanel){
        w = new JFrame();
        w.setResizable(false);
        w.add(gamePanel);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }
}

7. Input Output (src/GamePanel.java)
 //input
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        direction = Direction.Up;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        inGame = true;
        direction = Direction.Down;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
