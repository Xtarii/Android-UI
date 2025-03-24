import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  output: "export",
  basePath: process.env.ENV === "DEV" ? "" : "/Android-UI",

  images: {
    unoptimized: true
  }
};

export default nextConfig;
