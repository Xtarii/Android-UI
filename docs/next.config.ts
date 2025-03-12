import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  output: "export",
  basePath: process.env.ENV === "DEV" ? "" : "/Android-UI"
};

export default nextConfig;
