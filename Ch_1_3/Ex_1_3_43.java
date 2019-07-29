package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.io.File;

/**
 * Created by HuGuodong on 2019/7/29.
 */

public class Ex_1_3_43 {

  public static void print(String dir, int tabs) {
    File f = new File(dir);

    // save dir
    _Queue<File> dirs = new _Queue<>();
    for (int i = 0; i < tabs; i++) {
      StdOut.print("\t");
    }
    StdOut.printf("DIR: %s\n", f.getName());
    if (f.isDirectory()) {
      File[] files = f.listFiles();
      for (File ff : files) {
        if (ff.isFile()) {
          for (int i = 0; i < tabs; i++) {
            StdOut.print("\t");
          }
          StdOut.printf("-%s\n", ff.getName());
        } else {
          dirs.enqueue(ff);
        }
      }

      while (!dirs.isEmpty()) {
        print(dirs.dequeue().getAbsolutePath(), tabs + 1);
      }
    }
  }

  public static void main(String[] args) {
    print("E:\\GDUT\\Projects\\mydocker", 0);
//    int n = 6;
//    String s = String.format("%1$" + n + "s", "");
//    System.out.format("[%13s]%n", "\t");  // prints "[             ]" (13 spaces)
//    System.out.format("[%1$3s]%n", ""); // prints "[   ]" (3 spaces)
//    StdOut.printf("[%13s]\n", "");
//    DIR: mydocker
//    DIR: dockerdev
//    DIR: .Idea.share
//    DIR: .IdeaIC2019.2
//    DIR: Project
//    DIR: doodle
//        -README.md
//    DIR: .git
//        -config
//        -description
//        -HEAD
//        -index
//        -packed-refs
//    DIR: hooks
//        -applypatch-msg.sample
//        -commit-msg.sample
//        -post-update.sample
//        -pre-applypatch.sample
//        -pre-commit.sample
//        -pre-push.sample
//        -pre-rebase.sample
//        -pre-receive.sample
//        -prepare-commit-msg.sample
//        -update.sample
//    DIR: info
//        -exclude
//    DIR: logs
//        -HEAD
//    DIR: refs
//    DIR: heads
//        -master
//    DIR: remotes
//    DIR: origin
//        -HEAD
//    DIR: objects
//    DIR: 02
//        -d005077931c3b47a69c3713d8bcc7196d649c8
//    DIR: 11
//        -614dd9bcc599b8dfab4c6470f3fe86ea122240
//    DIR: 13
//        -9987377d434c8255fdd51f5d180cd6362fe5d6
//    DIR: 1a
//        -2cd4ee009c6555bb299d9e7a9e689779f88097
//    DIR: 1b
//        -518765fa102bb2b4a451749d96ce528f45ef19
//        -691672715b6279ee63fe58f6f464a60d9cbbad
//    DIR: 1c
//        -b90b722b3f245b3044c7ebea53dd2e42b61e3f
//    DIR: 1d
//        -a246fd74e072998c956b8e12f878fc5c3be204
//    DIR: 20
//        -4c16ecbd45a82a2df6692d31619b6cec0bdaee
//    DIR: 22
//        -2ea75048f13f16a9a66f6fcbb27b2ff5829f92
//    DIR: 25
//        -0596a7c540597ee9988883228a8d2014c57fb8
//    DIR: 2b
//        -cee9fe1a3df900d4b93f508c2ff2c3123fd8d9
//    DIR: 2f
//        -bcc3dcf177e657517960a1ce3e724f53dc42c4
//    DIR: 4a
//        -cc63ac70e52122f7f8b13badd5899468d909bc
//    DIR: 4c
//        -2cd7c5821e8e9118bcde77ac28dc894c3ce3c5
//    DIR: 4f
//        -13a8d46111e613daf70a8d46a7d480f3f99944
//    DIR: 51
//        -889e3efa6813087d02a28a3ccd1d788e2dd480
//    DIR: 52
//        -771efccd44b0382105a2fbba5c0758e55a6eb2
//    DIR: 57
//        -61a890d8960334769378f5fd9a1fc324d49963
//    DIR: 65
//        -52aec61d25150bf2eebeff0d942b1939272b7a
//    DIR: 66
//        -7fc042735a58c217726656fbf6109281365529
//    DIR: 75
//        -aec9562237b3e69c3b19280f174b34bbef6478
//    DIR: 78
//        -dcded94240206e142dce08b3feefdbbe09b85b
//    DIR: 80
//        -3a7b33f96af6487db43b3eb82f6d25645f0b2b
//    DIR: 83
//        -04bae34150d9dfb78bfb2313407f4562684c0c
//    DIR: 84
//        -2d9707fc181153351e124a65a13eb93aa208a3
//    DIR: 86
//        -970874ef4e0967c44297f8ab659b213035d211
//    DIR: 87
//        -58a1dbf17b24b890367d5c279eae2bdf3065cc
//    DIR: 8a
//        -5b0741e5d0f401f8fcbb2c011c14f871b79897
//    DIR: 92
//        -b372c8fd88ffe38bcd1860a324c7c2b1c0c53d
//    DIR: a6
//        -6c5b8b099a191fe250b2bf0fa559d4ede1b81c
//    DIR: aa
//        -74b48eb848ea2d95f7cd6b0e82c3b01efda102
//        -bc96fa0f294037093f8671f9221ac42edeec65
//    DIR: b2
//        -e36374fc28efe99563ab4a52093c802034decb
//    DIR: b3
//        -026077c695c273bc2bd50753ece0fb096fb5eb
//    DIR: bc
//        -51e82583e40937878e747b1ce8afc9627d368c
//    DIR: c3
//        -d57fcc141af49b09bc337778a7108069e20d07
//    DIR: cb
//        -26195a7698c632b5a5427d74d7af7c5a185f59
//        -6d7c92ecfa1642979fd969adc229c00e868208
//    DIR: db
//        -4d5a8f2c5717312b45f6b759d7e067959e8466
//    DIR: dc
//        -16d86fd19339fd630114fed3c919854d2ae16d
//        -4afd458b562b72012ddc93987ef11a801196a0
//    DIR: eb
//        -65301ab03f89b48b31bfda3b3e7a510533b09e
//    DIR: ef
//        -a85a91d51cc814733146898c31a3869310729d
//    DIR: f9
//        -5e805348f701303aacc4dd0e86a20b80a154e3
//    DIR: fe
//        -151eaabbb2e2ed544c16a00b8e53a467b08e0f
//    DIR: info
//    DIR: pack
//    DIR: refs
//    DIR: heads
//        -master
//    DIR: remotes
//    DIR: origin
//        -HEAD
//    DIR: tags
//    DIR: birthday2019
//        -Dockerfile
//        -Dockerfile.cross
//        -README.md
//        -surprise.go
//    DIR: cheers2019
//        -cheers.go
//        -Dockerfile
//        -Dockerfile.cross
//        -README.md
//    DIR: linux_tweet_app
//        -Dockerfile
//        -index-new.html
//        -index-original.html
//        -index.html
//        -linux.png
//        -README.md
//    DIR: .git
//        -config
//        -description
//        -HEAD
//        -index
//        -packed-refs
//    DIR: hooks
//        -applypatch-msg.sample
//        -commit-msg.sample
//        -post-update.sample
//        -pre-applypatch.sample
//        -pre-commit.sample
//        -pre-push.sample
//        -pre-rebase.sample
//        -pre-receive.sample
//        -prepare-commit-msg.sample
//        -update.sample
//    DIR: info
//        -exclude
//    DIR: logs
//        -HEAD
//    DIR: refs
//    DIR: heads
//        -master
//    DIR: remotes
//    DIR: origin
//        -HEAD
//    DIR: objects
//    DIR: 3b
//        -41de3f77d71d0a7d975ef239a6c36a2f7fab0a
//    DIR: 3d
//        -b7296c9dfa48918c50a897225a3547ae4228d1
//    DIR: 63
//        -fe1ebd87759f688b87c0a28c42042b83c5cc91
//    DIR: 65
//        -1ca39ce3447bc16921ef13a9f3eba5228b15e7
//    DIR: 76
//        -b830b5bedf9c4c6ec9d5a9f287272397813355
//    DIR: 77
//        -71e7e44236c3e6522fc49f1cb5b4408217ec4e
//    DIR: 86
//        -627418c9c9be0684d20525c30ea979a54cc7ab
//    DIR: 92
//        -20b61b5b534ea6468d3dcd178e5d2b26fde240
//    DIR: 9d
//        -ab462186bd7fb7c490d2e0eab7200e7badeb89
//    DIR: a7
//        -2bf0e3d1f3d43dad7ef07e207f60a33b176ec3
//    DIR: ae
//        -fdade030302798ebd8a6bb428e521e6c8dfbcb
//    DIR: d5
//        -13075e7076a93d828496cf3d9dc8bdb2f65650
//    DIR: d9
//        -ccb60ed779c6feab8f4b201fec770367fb6eba
//    DIR: f3
//        -86394d9f0ca6eceee6d31aa8d597608b7b2089
//    DIR: info
//    DIR: pack
//    DIR: refs
//    DIR: heads
//        -master
//    DIR: remotes
//    DIR: origin
//        -HEAD
//    DIR: tags
  }
}
