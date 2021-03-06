/*
 * This file is part of CycloneDX Core (Java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.cyclonedx.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.cyclonedx.model.Hash;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BomUtils {

    private BomUtils() { }

    /**
     * Calculates the hashes of the specified file.
     * @param file the File to calculate hashes on
     * @return a List of Hash objets
     * @throws IOException an IOException
     * @since 1.0.0
     */
    public static List<Hash> calculateHashes(File file) throws IOException {
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        final List<Hash> hashes = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file)) {
            hashes.add(new Hash(Hash.Algorithm.MD5, DigestUtils.md5Hex(fis)));
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            hashes.add(new Hash(Hash.Algorithm.SHA1, DigestUtils.sha1Hex(fis)));
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            hashes.add(new Hash(Hash.Algorithm.SHA_256, DigestUtils.sha256Hex(fis)));
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            hashes.add(new Hash(Hash.Algorithm.SHA_384, DigestUtils.sha384Hex(fis)));
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            hashes.add(new Hash(Hash.Algorithm.SHA_512, DigestUtils.sha512Hex(fis)));
        }
        return hashes;
    }
}
