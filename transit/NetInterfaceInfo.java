package p623;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-22
 */
public class NetInterfaceInfo {
    static String asHexString(byte[] bytes) {
        return bytes == null? "":
                IntStream.range(0, bytes.length)
                        .map(index -> bytes[index])
                        .map(number -> number & 0xFF)
                        .mapToObj("%02X"::formatted)
                        .collect(Collectors.joining(":"));
    }

    static String printInfo(NetworkInterface networkInterface) throws SocketException {
        throw new UnsupportedOperationException("to be implemented");
        // getName
        // isLoopback
        // getHardwareAddress
    }

    public static void main(String... args) throws SocketException {
    }
}
