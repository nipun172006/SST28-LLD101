#!/usr/bin/env bash
set -euo pipefail

repo_root=$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)
compile_root=$(mktemp -d "${TMPDIR:-/tmp}/sst28-lld-compile.XXXXXX")
trap 'rm -rf "$compile_root"' EXIT

source_dirs=(
  "$repo_root"/SOLID/*/src
  "$repo_root"/adapter-payments/src
  "$repo_root"/flyweight-markers/src
  "$repo_root"/immutable-tickets/src
  "$repo_root"/proxy-reports/src
  "$repo_root"/singleton-metrics/src
)

for source_dir in "${source_dirs[@]}"; do
  module_name=${source_dir#"$repo_root"/}
  module_name=${module_name//\//-}
  module_out="$compile_root/$module_name"
  source_list="$compile_root/$module_name.sources"

  mkdir -p "$module_out"
  find "$source_dir" -name '*.java' -print | sort > "$source_list"
  javac -d "$module_out" @"$source_list"
  printf 'Compiled %s\n' "${source_dir#"$repo_root"/}"
done
